package com.example.bd3delgadosergio.Activitys

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.isVisible
import com.example.bd3delgadosergio.BD.ListaDAO
import com.example.bd3delgadosergio.databinding.ActivityNuevoProductoBinding

class NuevoProductoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNuevoProductoBinding
    private lateinit var bd: ListaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuevoProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = ListaDAO(this)

        val categorias = bd.consultaNombreCategorias()
        categorias.add(0,"Seleccione una categoría")
        val arrayAdapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, categorias)
        binding.spinnerCategorias.adapter = arrayAdapter

        binding.btnAceptar.setOnClickListener {
            // Variables con el dato introducido por teclado
            val nombre = binding.txtNombre.text.toString()
            val url = binding.txtUrl.text.toString()

            val posicionSeleccionada = binding.spinnerCategorias.selectedItemId.toInt()

            // Si hay algún campo vacío
            if (nombre.isEmpty() || url.isEmpty() || posicionSeleccionada == 0) {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                bd.nuevoProducto(nombre, posicionSeleccionada, url)
                Toast.makeText(this, "Producto añadido correctamente!", Toast.LENGTH_LONG).show()

                binding.txtNombre.setText("")
                binding.txtUrl.setText("")
                binding.spinnerCategorias.get(0).isVisible = false

                finish()
            }
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}