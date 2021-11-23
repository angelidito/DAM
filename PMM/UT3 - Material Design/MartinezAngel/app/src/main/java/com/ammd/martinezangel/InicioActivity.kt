package com.ammd.martinezangel

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ammd.martinezangel.databinding.ActivityInicioBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.snackbar.Snackbar

class InicioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/0/0b/Facultad_de_Ciencias_Medican_UNAH.jpg")
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .circleCrop()
            .into(binding.imgHospital)

        binding.btnCall.setOnClickListener { askForPermissions() }
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }
    }


    fun askForPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            !=
            PackageManager.PERMISSION_GRANTED
        ) {
            if (
                ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.CALL_PHONE
                )
            ) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("¿Desea permitir llamadas desde la aplicación?")
                builder.setMessage("Pulse aceptar para poder llamar")
                builder.setPositiveButton("Aceptar") { _, _ ->
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        947
                    )
                }
                builder.setNegativeButton("Denegar") { _, _ ->
                    Snackbar.make(
                        binding.root,
                        "El permiso de llamada ha sido denegado.",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                builder.show()
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    947
                )
            }
        } else {
            callHospital()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            947 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    callHospital()
                }
            }
        }
    }

    private fun callHospital() {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:947262916"))
        startActivity(intent)
    }
}