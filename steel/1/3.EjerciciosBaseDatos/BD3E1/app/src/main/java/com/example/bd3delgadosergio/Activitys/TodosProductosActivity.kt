package com.example.bd3delgadosergio.Activitys

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
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bd3delgadosergio.BD.ListaDAO
import com.example.bd3delgadosergio.databinding.ActivityTodosProductosBinding
import com.example.bd3delgadosergio.EventosListener.EventosListener2
import com.example.bd3delgadosergio.Pojos.Producto
import com.example.bd3delgadosergio.Pojos.ProductoAdapter
import com.example.bd3delgadosergio.R
import com.google.android.material.snackbar.Snackbar

class TodosProductosActivity : AppCompatActivity(), EventosListener2 {
    private lateinit var binding: ActivityTodosProductosBinding
    private lateinit var adaptador: ProductoAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var bd: ListaDAO
    private lateinit var nombreProd: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTodosProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = ListaDAO(this)

        if (bd.hayProductos()) {
            binding.txtNoHayProductos.isVisible = false
            configurarRecyclerTodosProductos()
        }

        binding.btnNuevoProducto.setOnClickListener {
            intent = Intent(this, NuevoProductoActivity::class.java)
            actualizarProductos.launch(intent)
        }

        binding.btnOrdenarAlfabeticamente.setOnClickListener {
            configurarRecyclerOrdenadoAlfab()
        }

        binding.btnOrdenarCategorias.setOnClickListener {
            configurarRecyclerOrdenadosCat()
        }

        actualizarTextView()

        binding.btnBuscar.setOnClickListener {
            configurarRecyclerTodosProductos()
            if(binding.txtNombreProducto.text.isNotEmpty()){
                nombreProd = binding.txtNombreProducto.text.toString()
                configurarRecyclerProducto()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.opciones, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.categorias) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.productos) {
            val intent = Intent(this, TodosProductosActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.listaCompra) {
            val intent = Intent(this, ListaCompraActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    val actualizarProductos =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (bd.hayProductos()) {
                binding.txtNoHayProductos.isVisible = false
                configurarRecyclerTodosProductos()
            }
            actualizarTextView()
        }

    private fun actualizarTextView(){
        val autotextView = binding.txtNombreProducto
        val arrayTodosProductos = bd.consultaProductosArray()
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, arrayTodosProductos)
        autotextView.setAdapter(adapter)
    }

    private fun configurarRecyclerTodosProductos() {
        adaptador = ProductoAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)
        consultaProductosCategoria()
        binding.recyclerProductos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaProductosCategoria() {
        val myAsyncTask = MyAsyncTask().execute()
    }

    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<Producto>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Producto> {
            return bd.consultaTodosProductos()
        }

        override fun onPostExecute(result: MutableList<Producto>) {
            super.onPostExecute(result)
            adaptador.setProductos(result)
        }
    }

    private fun configurarRecyclerProducto() {
        adaptador = ProductoAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)
        consultaProductoString()
        binding.recyclerProductos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaProductoString() {
        val myAsyncTask = MyAsyncTask2().execute()
    }

    private inner class MyAsyncTask2() : AsyncTask<Void, Void, MutableList<Producto>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Producto> {
            return bd.consultaProductoStringSinCat(nombreProd)
        }

        override fun onPostExecute(result: MutableList<Producto>) {
            super.onPostExecute(result)
            adaptador.setProductos(result)
        }
    }

    private fun configurarRecyclerOrdenadoAlfab() {
        adaptador = ProductoAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)
        consultaProductosOrdenadosAlfab()
        binding.recyclerProductos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaProductosOrdenadosAlfab() {
        val myAsyncTask = MyAsyncTask3().execute()
    }

    private inner class MyAsyncTask3() : AsyncTask<Void, Void, MutableList<Producto>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Producto> {
            return bd.consultaTodosProductosOrdenados()
        }

        override fun onPostExecute(result: MutableList<Producto>) {
            super.onPostExecute(result)
            adaptador.setProductos(result)
        }
    }

    private fun configurarRecyclerOrdenadosCat() {
        adaptador = ProductoAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)
        consultaProductosOrdenadosCat()
        binding.recyclerProductos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaProductosOrdenadosCat() {
        val myAsyncTask = MyAsyncTask4().execute()
    }

    private inner class MyAsyncTask4() : AsyncTask<Void, Void, MutableList<Producto>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Producto> {
            return bd.consultaTodosProductosOrdenadosCat()
        }

        override fun onPostExecute(result: MutableList<Producto>) {
            super.onPostExecute(result)
            adaptador.setProductos(result)
        }
    }

    override fun onLongClickListener(producto: Producto) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(Html.fromHtml("<b>Confirmación<b>"))
        builder.setIcon(android.R.drawable.stat_notify_error)
        builder.setMessage("\n¿Desea eliminar este producto?")
        // Si aceptas el mensaje se elimina el producto
        builder.setPositiveButton("Aceptar") { _, _ ->
            bd.eliminarProducto(producto.denominacion)

            Snackbar.make(binding.root, "Eliminado correctamente!", Snackbar.LENGTH_LONG).show()
            configurarRecyclerTodosProductos()

            if (!bd.hayProductos())
                binding.txtNoHayProductos.isVisible = true

            actualizarTextView()
        }
        // Si cancelas el permiso se cierra esa ventana
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }
}