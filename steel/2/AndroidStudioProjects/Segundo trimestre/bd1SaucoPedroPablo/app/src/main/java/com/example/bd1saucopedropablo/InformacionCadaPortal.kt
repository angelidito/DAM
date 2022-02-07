package com.example.bd1saucopedropablo

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.bd1saucopedropablo.databinding.ActivityBusquedaHotelBinding
import com.example.bd1saucopedropablo.databinding.ActivityInformacionCadaPortalBinding
import com.google.android.material.snackbar.Snackbar

class InformacionCadaPortal : AppCompatActivity() {
    private lateinit var binding: ActivityInformacionCadaPortalBinding
    private lateinit var db: PortalDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        db = PortalDAO(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.caratula_hotel)
        binding = ActivityInformacionCadaPortalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var portal:Portal? = intent.getParcelableExtra<Portal>("Portal")

        //PASAS LOS DATOS DE PORTAL A LA SEGUNDA ACTIVIDAD
        binding.denominacion.text = portal?.denominacion
        binding.ubicacion.text = portal?.localidad
        binding.precio.text = "El precio por persona es: " + portal?.precio.toString() + "€"
        if (portal?.favorito == 1) {
            binding.favorito.text = "♥"
        } else {
            binding.favorito.text = "\uD83D\uDC94"
        }
        binding.detalles.text = portal?.detalles
        binding.actividades.text = portal?.actividades
        Glide.with(binding.root)
            .load(portal?.imagen)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imagen)

        //LLAMAR TELÉFONO
        binding.botonLlamar.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED
            ) {
                Snackbar.make(
                    binding.root, "Permiso NO Concedido", Snackbar.LENGTH_LONG
                ).show()
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        android.Manifest.permission.CALL_PHONE
                    )
                ) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Llamada")
                    builder.setMessage("Sirve para poder realizar una llamada telefónica")
                    builder.setPositiveButton("ACEPTAR") { _, _ ->
                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(android.Manifest.permission.CALL_PHONE), 123
                        )
                    }
                    builder.setNegativeButton("CANCELAR", null)
                    builder.show()
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.CALL_PHONE), 123
                    )
                }
            } else {
                Snackbar.make(binding.root, "Permiso Concedido", Snackbar.LENGTH_LONG).show()
                llamada(portal?.telefono.toString())
            }
        }
        //MANDAR MENSAJE
        binding.botonMensaje.setOnClickListener {
            val mensaje = portal?.email
            val intentMail = Intent(Intent.ACTION_SEND)
            intentMail.data = Uri.parse("gmail:")
            intentMail.type = "text/plain"
            intentMail.putExtra(Intent.EXTRA_EMAIL, mensaje)

            startActivity(Intent.createChooser(intentMail, "Mandar mensaje"))
        }
    }
    //LLAMAR TELÉFONO
    fun llamada(telefono:String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono))
        startActivity(intent)
    }

}
