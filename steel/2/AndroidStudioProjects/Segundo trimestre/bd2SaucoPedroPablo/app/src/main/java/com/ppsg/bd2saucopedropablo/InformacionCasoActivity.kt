package com.ppsg.bd2saucopedropablo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ppsg.bd2saucopedropablo.databinding.ActivityCasosBinding
import com.ppsg.bd2saucopedropablo.databinding.ActivityInformacionCasoBinding
import com.ppsg.bd2saucopedropablo.databinding.ActivityLoginBinding

class InformacionCasoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformacionCasoBinding
    private lateinit var db: BufeteDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        db = BufeteDAO(this)
        super.onCreate(savedInstanceState)
        binding = ActivityInformacionCasoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var casos: Casos? = intent.getParcelableExtra<Casos>("Casos")

        binding.numeroCaso.text = "El id del caso es -> " + casos?.numeroCaso.toString()
        binding.denominacion.text = "El nombre del caso es -> " + casos?.denominacion
        binding.fecha.text = "Fecha del caso -> " + casos?.fecha
        binding.caracteristicas.text = "Características:\n " + casos?.caracteristicas
        binding.numAbogado.text="El abogado asociado al caso es -> "+ casos?.numAbogado.toString()
    }
}