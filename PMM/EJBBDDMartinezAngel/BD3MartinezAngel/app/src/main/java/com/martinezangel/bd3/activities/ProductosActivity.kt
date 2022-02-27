package com.martinezangel.bd3.activities

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.martinezangel.bd3.bd.ComprasDAO
import com.martinezangel.bd3.databinding.ActivityProductosBinding
import com.martinezangel.bd3.enventlisteners.ProductoEventListener
import com.martinezangel.bd3.models.Producto
import com.martinezangel.bd3.R
import com.google.android.material.snackbar.Snackbar
import com.martinezangel.bd3.adapters.ProductoAdapter

class ProductosActivity : AppCompatActivity(), ProductoEventListener {
    private lateinit var binding: ActivityProductosBinding
    private lateinit var adaptador: ProductoAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var database: ComprasDAO
    private val recyclerORDENARaZ = "configurar recycler ordenado a z"
    private val recyclerORDENARcats = "configurar recycler ordenado cats"
    private val recyclerBUSCAR = "configurar recycler con busquedda"
    private val recyclerDEFAULT = "configurar recycler por defecto"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ComprasDAO(this)

        configurarRecycler(recyclerDEFAULT)
        autoCompleteTextViewConfig()

        binding.btnAAdirProducto.setOnClickListener {
            intent = Intent(this, AnadirProductoActivity::class.java)
            actualizarProductos.launch(intent)
        }
        binding.btnOdenarAZ.setOnClickListener {
            configurarRecycler(recyclerORDENARaZ)
        }
        binding.btnOrdenarCategoria.setOnClickListener {
            configurarRecycler(recyclerORDENARcats)
        }
        binding.btnBuscar.setOnClickListener {
//            if (binding.autocompleteProducto.text.isNullOrBlank())
            configurarRecycler(recyclerBUSCAR)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuItemLista -> {
                val intent = Intent(this, ListaActivity::class.java)
                startActivity(intent)
            }
            R.id.menuItemCategorias -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.menuItemProductos -> {
                val intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private val actualizarProductos =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            configurarRecycler(recyclerDEFAULT)
            autoCompleteTextViewConfig()
        }

    private fun autoCompleteTextViewConfig() {
        val autotextView = binding.autocompleteProducto
        val productosArray = database.getDenominacionesProductosArray()

        autotextView.setAdapter(
            ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                productosArray
            )
        )
    }

    private fun configurarRecycler(option: String) {
        adaptador = ProductoAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)

        CargaProductosMyAsyncTask(option).execute()

        if (option.compareTo(recyclerBUSCAR) != 0)
            binding.autocompleteProducto.text.clear()

        binding.recyclerListaProductos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }


    private inner class CargaProductosMyAsyncTask(val option: String) :
        AsyncTask<Void, Void, MutableList<Producto>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Producto> {
            if (option.compareTo(recyclerBUSCAR) == 0)
                return database.getProductos(binding.autocompleteProducto.text.toString())

            if (option.compareTo(recyclerORDENARaZ) == 0)
                return database.getProductosAtoZ()

            if (option.compareTo(recyclerORDENARcats) == 0)
                return database.getProductosOrderedByCategoria()

            // if (option.compareTo(recyclerDEFAULT) == 0)
            return database.getProductos()

        }

        override fun onPostExecute(result: MutableList<Producto>) {
            super.onPostExecute(result)
            adaptador.setProductos(result)
        }
    }

    override fun onLongClickListener(producto: Producto) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("¿Eliminar producto?")
        builder.setPositiveButton("Eliminar") { _, _ ->
            database.deleteProducto(producto.codigoProducto)
            Snackbar.make(
                binding.root,
                "Producto eliminado.",
                Snackbar.LENGTH_LONG
            ).show()
            configurarRecycler(recyclerDEFAULT)
            autoCompleteTextViewConfig()
        }
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }
}