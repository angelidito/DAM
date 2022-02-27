package com.martinezangel.bd3.activities

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.martinezangel.bd3.databinding.ActivityProductosCategoriaBinding
import com.google.android.material.snackbar.Snackbar
import android.widget.ArrayAdapter
import com.martinezangel.bd3.bd.ComprasDAO
import com.martinezangel.bd3.enventlisteners.ProductoEventListener
import com.martinezangel.bd3.models.Categoria
import com.martinezangel.bd3.models.Producto
import com.martinezangel.bd3.R
import com.martinezangel.bd3.adapters.ProductoAdapter

class ProductosCategoriaActivity : AppCompatActivity(), ProductoEventListener {
    private lateinit var binding: ActivityProductosCategoriaBinding
    private lateinit var adaptador: ProductoAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var database: ComprasDAO
    private lateinit var categoria: Categoria
    private val recyclerORDENAR = "configurar recycler ordenado"
    private val recyclerBUSCAR = "configurar recycler con busquedda"
    private val recyclerDEFAULT = "configurar recycler por defecto"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosCategoriaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ComprasDAO(this)

        categoria = intent.getParcelableExtra(MainActivity.CATEGORIA)!!

        binding.ttlTitulo.text = categoria.denominacion

        configurarRecycler(recyclerDEFAULT)
        autoCompleteTextViewConfig()

        binding.btnAAdirProducto.setOnClickListener {
            intent = Intent(this, AnadirProductoCategoriaActivity::class.java)
            intent.putExtra(MainActivity.CATEGORIA, categoria)
            actualizarProductos.launch(intent)
        }
        binding.btnOdenarAZ.setOnClickListener {
            configurarRecycler(recyclerORDENAR)
        }
        binding.btnBuscar.setOnClickListener {
//            if (!binding.autocompleteProducto.text.isNullOrBlank())
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
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { _ ->
            configurarRecycler(recyclerDEFAULT)
            autoCompleteTextViewConfig()
        }

    private fun autoCompleteTextViewConfig() {
        val autotextView = binding.autocompleteProducto
        val productosArray =
            database.getDenominacionesProductosFromCategoriaArray(categoria.codigoCategoria)

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
                return database.getProductosFromCategoria(
                    binding.autocompleteProducto.text.toString(),
                    categoria.codigoCategoria
                )

            if (option.compareTo(recyclerORDENAR) == 0)
                return database.getProductosFromCategoriaAtoZ(categoria.codigoCategoria)

            // if (option.compareTo(recyclerDEFAULT) == 0)
            return database.getProductosFromCategoria(categoria.codigoCategoria)
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