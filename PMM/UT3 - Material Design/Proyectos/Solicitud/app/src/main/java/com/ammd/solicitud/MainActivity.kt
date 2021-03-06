package com.ammd.solicitud

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ammd.solicitud.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWebpage.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://developer.android.com/")
            )
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Snackbar.make(
                    binding.root,
                    "No se encuentra navegador",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        binding.btnCallphone.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.CALL_PHONE
                )
                != PackageManager.PERMISSION_GRANTED
            ) {
                Snackbar.make(
                    binding.rootlayout,
                    "Permiso no concedido",
                    Snackbar.LENGTH_LONG
                ).show()
                if (
                    ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.CALL_PHONE
                    )
                ) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle(getString(R.string.titulo_mensaje_permiso_llamada))
                    builder.setMessage(getString(R.string.mensaje_permiso_llamada))
                    builder.setPositiveButton(getString(R.string.texto_btn_aceptar))
                    { _, _ ->
                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(Manifest.permission.CALL_PHONE),
                            123
                        )
                    }
                    builder.setPositiveButton("Denegar", null)
                    builder.show()
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        123
                    )
                }
            } else {
                Snackbar.make(
                    binding.rootlayout,
                    "Permiso concedido",
                    Snackbar.LENGTH_LONG
                ).show()
                llamada()
            }
        }

        fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)

            when (requestCode) {
                123 -> {
                    if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Snackbar.make(
                            binding.rootlayout,
                            "Acabas de conceder el permiso",
                            Snackbar.LENGTH_LONG
                        ).show()
                        llamada()
                    } else
                        Snackbar.make(
                            binding.rootlayout,
                            "No has concido el permiso",
                            Snackbar.LENGTH_LONG
                        ).show()
                }
                else ->
                    Snackbar.make(
                        binding.rootlayout,
                        "NADA",
                        Snackbar.LENGTH_LONG
                    ).show()
            }
        }
    }

    private fun llamada() {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:947749749"))
        startActivity(intent)
    }
}
