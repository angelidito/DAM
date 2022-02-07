package com.example.ej2_sauco_pedropablo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ej2_sauco_pedropablo.databinding.ActivityMainBinding
import com.example.ej2_sauco_pedropablo.databinding.ActivitySegundaActividadBinding

class SegundaActividad : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaActividadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Recoge el objeto del extra
        var monumento = intent.getParcelableExtra<Monumento>("Monumento")

        binding.titulo.text = monumento?.nombre
        binding.descripcion.text = monumento?.descipcion
        binding.ubicacion.text = monumento?.ubicacion
        binding.telefono.text = monumento?.telefono.toString()
        binding.gmail.text = monumento?.email
        Glide.with(binding.root)
            .load(monumento?.imagen)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imagen)
    }
}
