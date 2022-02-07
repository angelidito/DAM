package com.example.bd3delgadosergio.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bd3delgadosergio.BD.ListaDAO
import com.example.bd3delgadosergio.databinding.ActivityNuevaCategoriaBinding

class NuevaCategoriaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNuevaCategoriaBinding
    private lateinit var bd: ListaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuevaCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = ListaDAO(this)

        binding.btnAceptar.setOnClickListener {
            // Variables con el dato introducido por teclado
            val nombre = binding.txtNombre.text.toString()

            // Si hay algún campo vacío
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                bd.nuevaCategoria(nombre)
                Toast.makeText(this, "Categoría añadida correctamente!", Toast.LENGTH_LONG).show()

                binding.txtNombre.setText("")

                finish()
            }
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}