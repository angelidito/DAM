package com.ammd.bd1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ammd.bd1.databinding.ActivityInfoAlojamientoBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.snackbar.Snackbar

class InfoAlojamientoActivity : AppCompatActivity() {
    private lateinit var alojamiento: Alojamientos
    private lateinit var binding: ActivityInfoAlojamientoBinding
    private lateinit var database :AlojamientosDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoAlojamientoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAlojamientoData()

        binding.btnLlamar.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                solicitarPermisoLLamada()
            }
            else {
                llamar(alojamiento.telefono.toString())
            }
        }
        database= AlojamientosDAO(this)

        binding.infoCbFavorite.setOnClickListener{
            if (alojamiento.favorito == 0)
                alojamiento.favorito = 1
            else
                alojamiento.favorito = 0
            database.updateAlojamiento(alojamiento)

        }

        binding.btnCorreo.setOnClickListener {
            val correo = arrayOf(alojamiento.email)
            val intentEmail = Intent(Intent.ACTION_SEND)
            intentEmail.type = "text/plain"
            intentEmail.putExtra(Intent.EXTRA_EMAIL, correo)
            startActivity(Intent.createChooser(intentEmail, "Enviar correo"))
        }
    }


    private fun solicitarPermisoLLamada() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CALL_PHONE
            )
        ) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Permiso para llamar")
            builder.setMessage("Se requiere para llamar los alojamientos")
            builder.setPositiveButton("Aceptar") { _, _ ->
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    123
                )
            }
            builder.setNegativeButton("Cancelar", null)
            builder.show()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 123)
        }
    }

    private fun setAlojamientoData() {
        alojamiento = intent.getParcelableExtra("alojamiento")!!

        Glide.with(binding.root).load(alojamiento.imagen_alojamiento).centerCrop()
            .diskCacheStrategy(
                DiskCacheStrategy.ALL
            ).into(binding.infoImage)

        binding.infoCbFavorite.isChecked = alojamiento.favorito == 1

        binding.infoDenominacion.text = alojamiento.denominacion
        binding.infoLocalidad.text = alojamiento.localidad
        binding.infoPrecio.text = alojamiento.precio.toString() + " €/noche"
        binding.infoDetalles.text = alojamiento.detalles
        binding.infoActividades.text = alojamiento.actividades
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            123 -> {
                // Si aceptas el permiso
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    llamar(alojamiento.telefono.toString())
                }
                else
                    Snackbar.make(binding.root, "Permiso no concedido.", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun llamar(telefono:String) {
        startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefono")))
    }
}