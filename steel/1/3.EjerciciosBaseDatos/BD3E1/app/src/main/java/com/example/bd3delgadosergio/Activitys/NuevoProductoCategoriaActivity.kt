package com.example.bd3delgadosergio.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bd3delgadosergio.BD.ListaDAO
import com.example.bd3delgadosergio.databinding.ActivityNuevoProductoCategoriaBinding
import com.example.bd3delgadosergio.Pojos.Categoria

class NuevoProductoCategoriaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNuevoProductoCategoriaBinding
    private lateinit var bd: ListaDAO
    private lateinit var categoriaSeleccionada: Categoria

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuevoProductoCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = ListaDAO(this)

        categoriaSeleccionada = intent.getParcelableExtra<Categoria>(MainActivity.CATEGORIA)!!

        binding.txtCategoria.text = categoriaSeleccionada.nombre

        binding.btnAceptar.setOnClickListener {
            // Variables con el dato introducido por teclado
            val nombre = binding.txtNombre.text.toString()
            val url = binding.txtUrl.text.toString()
            val idCategoria = categoriaSeleccionada.codCategoria

            // Si hay algún campo vacío
            if (nombre.isEmpty() || url.isEmpty()) {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                bd.nuevoProducto(nombre, idCategoria, url)
                Toast.makeText(this, "Producto añadido correctamente!", Toast.LENGTH_LONG).show()

                binding.txtNombre.setText("")
                binding.txtUrl.setText("")
                binding.txtCategoria.text = ""

                finish()
            }
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}