package com.sde.delgadosergio

import android.Manifest
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
import com.google.android.material.snackbar.Snackbar
import com.sde.delgadosergio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.root).load("https://www.sanitas.es/media/imagen/mediana/img_home-fachada-virgen-del-mar/xhvdm.jpg.pagespeed.ic.7NCgrOX_H9.jpg").centerCrop().diskCacheStrategy(
            DiskCacheStrategy.ALL).into(binding.imgHospital)

        binding.btnLlamar.setOnClickListener{
            Toast.makeText(this, "da", Toast.LENGTH_LONG)

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
                llamada()
            }
        }

        binding.btnRegistro.setOnClickListener{
            intent= Intent(this,RegistroActivity::class.java)
            startActivity(intent)
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
        val numTelefono = "947153405"
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$numTelefono"))
        startActivity(intent)
    }
}