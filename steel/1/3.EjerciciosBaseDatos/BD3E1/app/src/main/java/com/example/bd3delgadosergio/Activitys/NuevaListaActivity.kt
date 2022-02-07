package com.example.bd3delgadosergio.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bd3delgadosergio.BD.ListaDAO
import com.example.bd3delgadosergio.databinding.ActivityNuevaListaBinding

class NuevaListaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNuevaListaBinding
    private lateinit var bd: ListaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuevaListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = ListaDAO(this)

        binding.btnAceptar.setOnClickListener {
            // Variables con el dato introducido por teclado
            val nombre = binding.txtNombre.text.toString()

            // Si hay algún campo vacío
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                bd.nuevaLista(nombre)
                Toast.makeText(this, "Lista creada correctamente!", Toast.LENGTH_SHORT).show()

                binding.txtNombre.setText("")

                finish()
            }
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}