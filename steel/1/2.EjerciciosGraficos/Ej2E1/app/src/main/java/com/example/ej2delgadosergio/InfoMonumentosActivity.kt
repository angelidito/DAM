package com.example.ej2delgadosergio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ej2delgadosergio.databinding.ActivityInfoMonumentosBinding

class InfoMonumentosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoMonumentosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoMonumentosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val monumento: Monumento? = intent.getParcelableExtra(MainActivity.MONUMENTO)
        binding.tituloNombreMonumento.text = monumento?.nombre
        Glide.with(binding.root).load(monumento?.imagen).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.imgMonumento)
        binding.descripcionMonumento.text = monumento?.descripcion
        binding.ubicacionMonumento.text = monumento?.ubicacion
        binding.emailMonumento.text = monumento?.email
        binding.telefonoMonumento.text = monumento?.telefono

        binding.btnVolver.setOnClickListener{
            finish()
        }
    }
}