package com.example.ejpracticaparaexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ejpracticaparaexamen.IntroducirCodigo.Companion.MONUMENTO
import com.example.ejpracticaparaexamen.databinding.ActivityInfoMonumentoBinding

class ActivityInfoMonumento : AppCompatActivity() {
    private lateinit var binding: ActivityInfoMonumentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoMonumentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var monumento: Monumento? = intent.getParcelableExtra(MONUMENTO)
        binding.tituloNombreMonumento.text = monumento?.nombre
        Glide.with(binding.root).load(monumento?.imagen).centerCrop().diskCacheStrategy(
            DiskCacheStrategy.ALL).into(binding.imgMonumento)
        binding.descripcionMonumento.text = monumento?.descripcion
        binding.emailMonumento.text = monumento?.email
        binding.telefonoMonumento.text = monumento?.telefono

        binding.btnVolver.setOnClickListener{
            finish()
        }
    }
}