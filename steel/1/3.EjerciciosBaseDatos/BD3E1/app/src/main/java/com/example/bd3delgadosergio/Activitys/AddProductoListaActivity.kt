package com.example.bd3delgadosergio.Activitys

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.isVisible
import com.example.bd3delgadosergio.BD.ListaDAO
import com.example.bd3delgadosergio.Pojos.ListaCompra
import com.example.bd3delgadosergio.databinding.ActivityAddProductoListaBinding

class AddProductoListaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductoListaBinding
    private lateinit var bd: ListaDAO
    private lateinit var listaSeleccionada: ListaCompra

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductoListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = ListaDAO(this)

        listaSeleccionada = intent.getParcelableExtra(InfoListaCompra.LISTA)!!

        val productos = bd.consultaNombreProductos()
        productos.add(0,"Seleccione un producto")
        val arrayAdapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, productos)
        binding.spinnerProductos.adapter = arrayAdapter

        binding.btnAceptar.setOnClickListener {
            // Variables con el dato introducido por teclado
            val cantidad = binding.txtCantidad.text.toString()

            val posicionSeleccionada = binding.spinnerProductos.selectedItemPosition

            // Si hay algún campo vacío
            if (cantidad.isEmpty() || posicionSeleccionada == 0) {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                bd.addProductoLista(listaSeleccionada.idLista, posicionSeleccionada, cantidad.toInt())
                Toast.makeText(this, "Producto añadido correctamente!", Toast.LENGTH_LONG).show()

                binding.txtCantidad.setText("")
                binding.spinnerProductos.get(0).isVisible = false

                finish()
            }
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}