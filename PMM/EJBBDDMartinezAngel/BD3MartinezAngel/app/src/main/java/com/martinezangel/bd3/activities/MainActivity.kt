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
import com.martinezangel.bd3.bd.ComprasDAO
import com.martinezangel.bd3.databinding.ActivityMainBinding
import com.martinezangel.bd3.enventlisteners.CategoriaEventListener
import com.martinezangel.bd3.models.Categoria
import com.martinezangel.bd3.R
import com.google.android.material.snackbar.Snackbar
import com.martinezangel.bd3.adapters.CategoriaAdapter

class MainActivity : AppCompatActivity(), CategoriaEventListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: CategoriaAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var database: ComprasDAO

    companion object {
        const val CATEGORIA = "categoria"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ComprasDAO(this)

        configurarRecycler()

        binding.btnAAdirCatagoria.setOnClickListener {
            intent = Intent(this, AnadirCategoriaActivity::class.java)
            actualizarCategorias.launch(intent)
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

    private val actualizarCategorias =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { _ ->
            configurarRecycler()
        }

    private fun configurarRecycler() {
        adaptador = CategoriaAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)

        CargaCategoriasAsyncTask().execute()

        binding.recyclerCategorias.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private inner class CargaCategoriasAsyncTask() :
        AsyncTask<Void, Void, MutableList<Categoria>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Categoria> {
            return database.getCategorias()
        }

        override fun onPostExecute(result: MutableList<Categoria>) {
            super.onPostExecute(result)
            adaptador.setCategorias(result)
        }
    }

    override fun onClickListener(categoria: Categoria) {
        intent = Intent(this, ProductosCategoriaActivity::class.java)
        intent.putExtra(CATEGORIA, categoria)
        startActivity(intent)
    }

    override fun onLongClickListener(categoria: Categoria) {
        if (database.getProductosFromCategoria(categoria.codigoCategoria).isEmpty()) {
            Snackbar.make(
                binding.root,
                "No puede borrar una categoría con productos.",
                Snackbar.LENGTH_LONG
            ).show()
            return
        }

        val builder = AlertDialog.Builder(this)
        builder.setTitle("¿Eliminar la categoría?>")

        builder.setPositiveButton("Eliminar") { _, _ ->
            database.deleteCategoria(categoria.codigoCategoria)
            Snackbar.make(
                binding.root,
                "La categoría ${categoria.denominacion} ha sido eliminada.",
                Snackbar.LENGTH_LONG
            ).show()
            configurarRecycler()
        }
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }
}