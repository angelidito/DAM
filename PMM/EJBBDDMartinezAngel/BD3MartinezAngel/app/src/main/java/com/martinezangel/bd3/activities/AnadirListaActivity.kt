package com.martinezangel.bd3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.martinezangel.bd3.bd.ComprasDAO
import com.martinezangel.bd3.databinding.ActivityAnadirListaBinding

class AnadirListaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnadirListaBinding
    private lateinit var database: ComprasDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnadirListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ComprasDAO(this)

        binding.btnAAdir.setOnClickListener {
            val denominacion = binding.txtDenominacionLista.text.toString()
            if (denominacion.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Indique un nonbre para la lista",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            database.addLista(denominacion)
            Toast.makeText(
                this,
                "La lista $denominacion ha sido añadida.",
                Toast.LENGTH_LONG
            ).show()
            finish()
        }
    }
}