package com.martinezangel.bd3.activities

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.martinezangel.bd3.bd.ComprasDAO
import com.martinezangel.bd3.databinding.ActivityAnadirProductoBinding

class AnadirProductoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnadirProductoBinding
    private lateinit var database: ComprasDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnadirProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ComprasDAO(this)

        val categorias = database.getCategorias()
        val nombresCatecoriasArray: ArrayList<String> = ArrayList()

        nombresCatecoriasArray.add(0, "- categoría -")
        for (i in 0 until categorias.size) {
            nombresCatecoriasArray.add(categorias[i].denominacion)
        }

        binding.spnCategorias.adapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_dropdown_item,
            categorias
        )

        binding.btnAAdir.setOnClickListener {
            val denominacion = binding.txtDenominacionCategoria.text.toString()
            val urlImagen = binding.txtUrlImagenProducto.text.toString()

            val spnPosition = binding.spnCategorias.selectedItemId.toInt()

            if (denominacion.isNullOrBlank() || spnPosition == 0 || urlImagen.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Indique nombre, categoría y url para el producto.",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            database.addProducto(
                denominacion,
                categorias[spnPosition - 1].codigoCategoria,
                urlImagen
            )
            Toast.makeText(
                this,
                "Producto añadido.",
                Toast.LENGTH_LONG
            ).show()
            finish()
        }
    }
}