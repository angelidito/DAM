package com.martinezangel.bd3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.martinezangel.bd3.bd.ComprasDAO
import com.martinezangel.bd3.databinding.ActivityAnadirCategoriaBinding

class AnadirCategoriaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnadirCategoriaBinding
    private lateinit var database: ComprasDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnadirCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ComprasDAO(this)

        binding.btnAAdir.setOnClickListener {
            val denominacion = binding.txtDenominacionCategoria.text.toString()
            if (denominacion.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Indique un nonbre para la categoría",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            database.addCategoria(denominacion)
            Toast.makeText(
                this,
                "La categoría $denominacion ha sido añadida.",
                Toast.LENGTH_LONG
            ).show()
            finish()
        }

    }
}