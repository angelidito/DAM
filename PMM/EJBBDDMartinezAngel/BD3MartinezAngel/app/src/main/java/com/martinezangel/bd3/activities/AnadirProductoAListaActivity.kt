package com.martinezangel.bd3.activities

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.martinezangel.bd3.bd.ComprasDAO
import com.martinezangel.bd3.models.Lista
import com.martinezangel.bd3.databinding.ActivityAnadirProductoAListaBinding
import com.martinezangel.bd3.models.Producto

class AnadirProductoAListaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnadirProductoAListaBinding
    private lateinit var database: ComprasDAO
    private lateinit var lista: Lista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnadirProductoAListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ComprasDAO(this)
        lista = intent.getParcelableExtra(DatosListaActivity.LISTA)!!

        val productos = database.getProductos()
        val nombresProductosArray: ArrayList<String> = ArrayList()

        nombresProductosArray.add(0, "- productos -")
        for (i in 0 until productos.size) {
            nombresProductosArray.add(productos[i].denominacion)
        }

        binding.spnProductos.adapter =
            ArrayAdapter(
                this,
                R.layout.simple_spinner_dropdown_item,
                nombresProductosArray
            )

        binding.btnAAdir.setOnClickListener {
            val cantidad = binding.txtPantidadProducto.text.toString()
            val spnPosition = binding.spnProductos.selectedItemPosition

            if (spnPosition == 0 || cantidad.isBlank()) {
                Toast.makeText(
                    this,
                    "Indique producto y cantidad.",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            database.addProductoToLista(
                lista.codigoLista,
                productos[spnPosition - 1].codigoProducto,
                cantidad.toInt()
            )
            Toast.makeText(
                this,
                "Producto añadido a la lista ${lista.denominacion}.",
                Toast.LENGTH_LONG
            ).show()
            finish()
        }
    }

    private fun setOnClickListener(productos: MutableList<Producto>) {

    }
}