package com.martinezangel.bd3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.martinezangel.bd3.bd.ComprasDAO
import com.martinezangel.bd3.databinding.ActivityAnadirProductoCategoriaBinding
import com.martinezangel.bd3.models.Categoria

class AnadirProductoCategoriaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnadirProductoCategoriaBinding
    private lateinit var database: ComprasDAO
    private lateinit var categoria: Categoria

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnadirProductoCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ComprasDAO(this)
        categoria = intent.getParcelableExtra<Categoria>(MainActivity.CATEGORIA)!!

        binding.lblCategorias.text = categoria.denominacion

        binding.btnAAdir.setOnClickListener {
            val denominacion = binding.txtDenominacionProducto.text.toString()
            val urlImagen = binding.txtUrlImagenProducto.text.toString()

            if (denominacion.isNullOrBlank() || urlImagen.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Indique nombre y url para el producto.",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            database.addProducto(denominacion, categoria.codigoCategoria, urlImagen)
            Toast.makeText(
                this,
                "Producto añadido.",
                Toast.LENGTH_LONG
            ).show()
            finish()
        }
    }
}