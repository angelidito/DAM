package com.example.bd3delgadosergio.Activitys

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bd3delgadosergio.databinding.ActivityProductosBinding
import com.google.android.material.snackbar.Snackbar
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import com.example.bd3delgadosergio.BD.ListaDAO
import com.example.bd3delgadosergio.EventosListener.EventosListener2
import com.example.bd3delgadosergio.Pojos.Categoria
import com.example.bd3delgadosergio.Pojos.Producto
import com.example.bd3delgadosergio.Pojos.ProductoAdapter
import com.example.bd3delgadosergio.R

class ProductosActivity : AppCompatActivity(), EventosListener2 {
    private lateinit var binding: ActivityProductosBinding
    private lateinit var adaptador: ProductoAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var bd: ListaDAO
    private lateinit var codCategoria: String
    private lateinit var nombreProd: String
    private lateinit var categoriaSeleccionada: Categoria

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = ListaDAO(this)

        categoriaSeleccionada = intent.getParcelableExtra(MainActivity.CATEGORIA)!!
        codCategoria = categoriaSeleccionada!!.codCategoria.toString()
        binding.tituloProductos.text = categoriaSeleccionada.nombre

        if (bd.tieneProductos(categoriaSeleccionada.codCategoria)) {
            binding.txtNoHayProductos.isVisible = false
            configurarRecycler()
        }

        binding.btnNuevoProducto.setOnClickListener {
            intent = Intent(this, NuevoProductoCategoriaActivity::class.java)
            intent.putExtra(MainActivity.CATEGORIA, categoriaSeleccionada)
            actualizarProductos.launch(intent)
        }

        binding.btnOrdenar.setOnClickListener {
            configurarRecyclerOrdenado()
        }

        actualizarTextView()

        binding.btnBuscar.setOnClickListener {
            configurarRecycler()
            if(binding.txtNombreProducto.text.isNotEmpty()){
                nombreProd = binding.txtNombreProducto.text.toString()
                configurarRecyclerProductoCat()
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
            if (bd.tieneProductos(categoriaSeleccionada.codCategoria)) {
                binding.txtNoHayProductos.isVisible = false
                configurarRecycler()
            }
            actualizarTextView()
        }

    private fun actualizarTextView(){
        val autotextView = binding.txtNombreProducto
        val arrayProductosCategoria = bd.consultaProductosCategoriaArray(codCategoria)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, arrayProductosCategoria)
        autotextView.setAdapter(adapter)
    }

    private fun configurarRecycler() {
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
            return bd.consultaProductosCategoria(codCategoria)
        }

        override fun onPostExecute(result: MutableList<Producto>) {
            super.onPostExecute(result)
            adaptador.setProductos(result)
        }
    }

    private fun configurarRecyclerProductoCat() {
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
            return bd.consultaProductoString(nombreProd, codCategoria)
        }

        override fun onPostExecute(result: MutableList<Producto>) {
            super.onPostExecute(result)
            adaptador.setProductos(result)
        }
    }

    private fun configurarRecyclerOrdenado() {
        adaptador = ProductoAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)
        consultaProductosOrdenados()
        binding.recyclerProductos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaProductosOrdenados() {
        val myAsyncTask = MyAsyncTask3().execute()
    }

    private inner class MyAsyncTask3() : AsyncTask<Void, Void, MutableList<Producto>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Producto> {
            return bd.consultaProductosCategoriaOrdenados(codCategoria)
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
            configurarRecycler()

            if (!bd.tieneProductos(categoriaSeleccionada.codCategoria))
                binding.txtNoHayProductos.isVisible = true

            actualizarTextView()
        }
        // Si cancelas el permiso se cierra esa ventana
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }
}