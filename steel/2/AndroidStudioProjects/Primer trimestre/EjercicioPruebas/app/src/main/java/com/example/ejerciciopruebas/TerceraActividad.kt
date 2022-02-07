package com.example.ejerciciopruebas

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ejerciciopruebas.databinding.ActivityTerceraActividadBinding
import com.google.android.material.snackbar.Snackbar
import java.util.jar.Manifest


class TerceraActividad : AppCompatActivity() {
    private lateinit var binding: ActivityTerceraActividadBinding
    private lateinit var monumentoCall:Monumento

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerceraActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recoge el objeto del extra
        var monumento = intent.getParcelableExtra<Monumento>("Monumento")

        binding.titulo.text = monumento?.nombre
        binding.ubicacion.text = monumento?.ubicacion
        binding.telefono.text = monumento?.telefono.toString()
        binding.gmail.text = monumento?.email
        Glide.with(binding.root)
            .load(monumento?.imagen)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imagen)

        binding.botonMensaje.setOnClickListener {
            if (monumento != null) {
                correoEvento(monumento)
            }
        }
        binding.botonLlamar.setOnClickListener {
            if (monumento != null) {
                onClickLlamar(monumento)
            }
        }
    }

    //COMO MANDAR CORREOS
    fun correoEvento(monumento: Monumento) {
        val mensaje = monumento.email
        val intentMail = Intent(Intent.ACTION_SEND)
        intentMail.data = Uri.parse("gmail:")
        intentMail.type = "text/plain"
        intentMail.putExtra(Intent.EXTRA_EMAIL, mensaje)

        startActivity(Intent.createChooser(intentMail, "Mandar mensaje"))
    }

    fun onClickLlamar(monumento: Monumento) {
        monumentoCall = monumento
        // Si el permiso no está aceptado
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Muestra el mensaje explicando el permiso
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CALL_PHONE)
            ) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Permiso Necesario")
                builder.setMessage("Este permiso sirve para realizar llamadas \nDebe ser aceptado")
                // Si aceptas el mensaje se muestra la ventana propia de aceptar el permiso
                builder.setPositiveButton("Aceptar") {
                    _, _ -> ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 123)
                }
                // Si cancelas el permiso se cierra esa ventana
                builder.setNegativeButton("Cancelar", null)
                builder.show()
            }
            // Se muestra la ventana propia de aceptar el permiso
            else {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 123)
            }
        }
        // Si el permiso ya estaba concedido, llama al método de realizar la llamada
        else {
            llamada()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            123 -> {
                // Si aceptas el permiso
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    llamada()
                }
                // Si cancelas el permiso
                else
                    Snackbar.make(binding.root, "Permiso no concedido :(", Snackbar.LENGTH_LONG).show()
            }
            else -> Snackbar.make(binding.root, "", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun llamada() {
        //El "tel:" sirve para que pille el número de teléfono correctamente
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + monumentoCall.telefono))
        startActivity(intent)
    }
}
