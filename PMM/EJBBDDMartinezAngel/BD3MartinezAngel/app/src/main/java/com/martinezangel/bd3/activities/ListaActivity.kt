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
import com.martinezangel.bd3.databinding.ActivityListaBinding
import com.martinezangel.bd3.enventlisteners.ListaEventListener
import com.martinezangel.bd3.models.Lista
import com.martinezangel.bd3.R
import com.google.android.material.snackbar.Snackbar
import com.martinezangel.bd3.adapters.ListaAdapter

class ListaActivity : AppCompatActivity(), ListaEventListener {
    private lateinit var binding: ActivityListaBinding
    private lateinit var adaptador: ListaAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var database: ComprasDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ComprasDAO(this)

        configurarRecycler()

        binding.btnAAdirLista.setOnClickListener {
            intent = Intent(this, AnadirListaActivity::class.java)
            actualizarListas.launch(intent)
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

    private val actualizarListas =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { _ ->
            configurarRecycler()
        }

    companion object {
        const val LISTA = "lista"
    }

    private fun configurarRecycler() {
        adaptador = ListaAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 1)

        CargaListasAsyncTask().execute()

        binding.recyclerListasCompra.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private inner class CargaListasAsyncTask() : AsyncTask<Void, Void, MutableList<Lista>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Lista> {
            return database.getListas()
        }

        override fun onPostExecute(result: MutableList<Lista>) {
            super.onPostExecute(result)
            adaptador.setListas(result)
        }
    }


    override fun onClickListener(lista: Lista) {
        intent = Intent(this, DatosListaActivity::class.java)
        intent.putExtra(LISTA, lista)
        startActivity(intent)
    }

    override fun onLongClickListener(lista: Lista) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("¿Eliminar la lista?")

        builder.setPositiveButton("Eliminar") { _, _ ->
            database.deleteLista(lista.codigoLista)
            Snackbar.make(
                binding.root,
                "La lista ${lista.denominacion} ha sido elimidada",
                Snackbar.LENGTH_LONG
            ).show()
            configurarRecycler()
        }
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }
}