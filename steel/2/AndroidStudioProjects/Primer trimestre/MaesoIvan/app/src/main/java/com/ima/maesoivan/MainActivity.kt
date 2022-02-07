package com.ima.maesoivan

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.snackbar.Snackbar
import com.ima.maesoivan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(binding.root).load("data:image/png;base64,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").centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL).circleCrop().into(binding.imagenHos)

        binding.registro.setOnClickListener {
            intent =Intent(this, Registro::class.java)
            startActivity(intent)
        }

        binding.llamar.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Snackbar.make(binding.root, "Permiso no concedido", Snackbar.LENGTH_LONG).show()
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.CALL_PHONE
                    )
                ) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Permiso para llamar")
                    builder.setMessage("Este permiso sirve...")
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
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        123
                    )
                }
            } else {
                Snackbar.make(binding.root, "Permiso concedido", Snackbar.LENGTH_LONG).show()
                val intent =
                    Intent(Intent.ACTION_CALL, Uri.parse("tel:947132865"))
                startActivity(intent)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            123-> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Snackbar.make(
                            binding.root,
                            "Acabas de conceder el permiso",
                            Snackbar.LENGTH_LONG
                        ).show()
                        llamada()
                    }
                    else
                        Snackbar.make(
                            binding.root,
                            "No has concedido el permiso",
                            Snackbar.LENGTH_LONG
                        ).show()
                }

                else -> Snackbar.make(binding.root,"Nada",Snackbar.LENGTH_LONG).show()
            }
        }

        fun llamada(){
            val intent=Intent(Intent.ACTION_CALL,Uri.parse("tel:947132865"))
            startActivity(intent)
        }
}