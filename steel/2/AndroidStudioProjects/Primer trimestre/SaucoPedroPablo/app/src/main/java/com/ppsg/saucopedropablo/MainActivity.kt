package com.ppsg.saucopedropablo

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.ppsg.saucopedropablo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var imagen: String ="data:image/jpeg;base64,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"
    var telefono: String ="665355322"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.root)
            .load(imagen)
            .centerCrop()
            .into(binding.imagen)


        binding.registro.setOnClickListener {
            intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }

        binding.llamar.setOnClickListener {
            onClickLlamar()
        }

    }

    fun onClickLlamar() {
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
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono))
        startActivity(intent)
    }
}