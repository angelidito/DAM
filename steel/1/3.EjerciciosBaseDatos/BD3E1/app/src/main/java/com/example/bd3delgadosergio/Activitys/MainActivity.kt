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
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bd3delgadosergio.BD.ListaDAO
import com.example.bd3delgadosergio.databinding.ActivityMainBinding
import com.example.bd3delgadosergio.EventosListener.EventosListener
import com.example.bd3delgadosergio.Pojos.Categoria
import com.example.bd3delgadosergio.Pojos.CategoriaAdapter
import com.example.bd3delgadosergio.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: CategoriaAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var bd: ListaDAO

    companion object{
        const val CATEGORIA = "categoria"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = ListaDAO(this)

        binding.btnNuevaCategoria.setOnClickListener {
            intent = Intent(this, NuevaCategoriaActivity::class.java)
            actualizarCategorias.launch(intent)
        }

        if (bd.hayCategorias()) {
            binding.txtNoHayCategorias.isVisible = false
            configurarRecycler()
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

    val actualizarCategorias =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (bd.hayCategorias()) {
                binding.txtNoHayCategorias.isVisible = false
                configurarRecycler()
            } else {
                binding.txtNoHayCategorias.isVisible = true
            }
        }

    private fun configurarRecycler() {
        adaptador = CategoriaAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)
        consultaCategorias()
        binding.recyclerCategorias.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaCategorias() {
        val myAsyncTask = MyAsyncTask().execute()
    }

    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<Categoria>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Categoria> {
            return bd.consultaCategorias()
        }

        override fun onPostExecute(result: MutableList<Categoria>) {
            super.onPostExecute(result)
            adaptador.setCategorias(result)
        }
    }

    override fun onClickListener(categoria: Categoria) {
        intent = Intent(this, ProductosActivity::class.java)
        intent.putExtra(CATEGORIA, categoria)
        startActivity(intent)
    }

    override fun onLongClickListener(categoria: Categoria) {
        var tieneProductos = bd.tieneProductos(categoria.codCategoria)

        if (tieneProductos){
            Snackbar.make(binding.root, "Esta categoría tiene productos, eliminelos primero", Snackbar.LENGTH_LONG).show()
        }
        else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(Html.fromHtml("<b>Confirmación<b>"))
            builder.setIcon(android.R.drawable.stat_notify_error)
            builder.setMessage("\n¿Desea eliminar esta categoría?")
            // Si aceptas el mensaje se elimina la categoría
            builder.setPositiveButton("Aceptar") { _, _ ->
                bd.eliminarCategoria(categoria.nombre)

                Snackbar.make(binding.root, "Eliminado correctamente!", Snackbar.LENGTH_LONG).show()
                configurarRecycler()

                if (!bd.hayCategorias())
                    binding.txtNoHayCategorias.isVisible = true
            }
            // Si cancelas el permiso se cierra esa ventana
            builder.setNegativeButton("Cancelar", null)
            builder.show()
        }
    }
}