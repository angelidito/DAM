package com.sde.bd1delgadosergio

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.snackbar.Snackbar
import com.sde.bd1delgadosergio.databinding.ActivityInfoCadaAlojamientoBinding

class InfoCadaAlojamiento : AppCompatActivity() {
    private lateinit var alojamiento: Alojamiento
    private lateinit var binding:ActivityInfoCadaAlojamientoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoCadaAlojamientoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        alojamiento = intent.getParcelableExtra(BuscarActivity.ALOJAMIENTO)!!
        binding.tituloNombreAlojamiento.text = alojamiento.nombre
        Glide.with(binding.root).load(alojamiento.imagen).centerCrop().diskCacheStrategy(
            DiskCacheStrategy.ALL).into(binding.imgAlojamiento)
        binding.localidadAlojamiento.text = alojamiento.localidad
        binding.precioAlojamiento.text = alojamiento.precio.toString() + "€ persona / noche"
        binding.detallesAlojamiento.text = alojamiento.detalles
        binding.actividadesAlojamiento.text = alojamiento.actividades

        if (alojamiento.favorito == 1){
            binding.favorito.text = "Añadido a favoritos! ❤"
        }
        else {
            binding.favorito.text = ""
        }

        binding.btnLlamar.setOnClickListener {
            // Si el permiso no está aceptado
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Muestra el mensaje explicando el permiso
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)
                ) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Permiso Necesario")
                    builder.setMessage("Este permiso sirve para realizar llamadas \nDebe ser aceptado")
                    // Si aceptas el mensaje se muestra la ventana propia de aceptar el permiso
                    builder.setPositiveButton("Aceptar") {
                            _, _ -> ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 123)
                    }
                    // Si cancelas el permiso se cierra esa ventana
                    builder.setNegativeButton("Cancelar", null)
                    builder.show()
                }
                // Se muestra la ventana propia de aceptar el permiso
                else {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 123)
                }
            }
            // Si el permiso ya estaba concedido, llama al método de realizar la llamada
            else {
                llamada(alojamiento.telefono.toString())
            }
        }

        binding.btnEmail.setOnClickListener {
            val mail = arrayOf(alojamiento.email)
            val intentEmail = Intent(Intent.ACTION_SEND)
            intentEmail.type = "text/plain"
            intentEmail.putExtra(Intent.EXTRA_EMAIL, mail)
            startActivity(Intent.createChooser(intentEmail, "Enviar email"))
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            123 -> {
                // Si aceptas el permiso
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    llamada(alojamiento.telefono.toString())
                }
                // Si cancelas el permiso
                else
                    Snackbar.make(binding.root, "Permiso no concedido :(", Snackbar.LENGTH_LONG).show()
            }
            else -> Snackbar.make(binding.root, "", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun llamada(telefono:String) {
        //El "tel:" sirve para que pille el número de teléfono correctamente
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$telefono"))
        startActivity(intent)
    }
}