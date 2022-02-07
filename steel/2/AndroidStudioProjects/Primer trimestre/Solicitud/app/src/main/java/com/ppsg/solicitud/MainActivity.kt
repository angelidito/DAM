package com.ppsg.solicitud

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.ppsg.solicitud.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnWebpage.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("htts//developer.android.com")
            )
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Snackbar.make(
                    binding.rootlayout, "No se encuentra un navegador",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
        binding.btnCallphone.setOnClickListener {
            if (ContextCompat.checkSelfPermission
                    (
                    this,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Snackbar.make(
                    binding.rootlayout,
                    "Permiso NO Concedido", Snackbar.LENGTH_LONG)
                    .show()
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        android.Manifest.permission.CALL_PHONE
                    )
                ) {
                    val builder=AlertDialog.Builder(this)
                    builder.setTitle(getString(R.string.titulo_permiso))
                    builder.setMessage(getString(R.string.explicacion_permiso))
                    builder.setPositiveButton(getString(R.string.aceptar)){
                        _,_->
                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(android.Manifest.permission.CALL_PHONE), 123
                        )
                    }
                    builder.setNegativeButton(getString(R.string.cancelar),null)
                    builder.show()
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.CALL_PHONE), 123
                    )
                }
            } else {
                Snackbar.make(binding.rootlayout, "Permiso Concedido", Snackbar.LENGTH_LONG).show()
            }
            llamada()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            123 -> {
                if (grantResults.isNotEmpty()
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    Snackbar.make(
                        binding.rootlayout,
                        "Acabas de conceder el permiso",
                        Snackbar.LENGTH_LONG
                    ).show()
                    llamada()
                } else {
                    Snackbar.make(
                        binding.rootlayout,
                        "No has concedido el permiso",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
            else -> {
                Snackbar.make(
                    binding.rootlayout,
                    "NADA",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    fun llamada() {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:665355322"))
        startActivity(intent)
    }
}