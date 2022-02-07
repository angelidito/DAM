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
import com.example.bd3delgadosergio.databinding.ActivityListaCompraBinding
import com.example.bd3delgadosergio.EventosListener.EventosListener3
import com.example.bd3delgadosergio.Pojos.ListaCompra
import com.example.bd3delgadosergio.Pojos.ListasAdapter
import com.example.bd3delgadosergio.R
import com.google.android.material.snackbar.Snackbar

class ListaCompraActivity : AppCompatActivity(), EventosListener3 {
    private lateinit var binding: ActivityListaCompraBinding
    private lateinit var adaptador: ListasAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var bd: ListaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListaCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = ListaDAO(this)

        binding.btnNuevaLista.setOnClickListener {
            intent = Intent(this, NuevaListaActivity::class.java)
            actualizarListas.launch(intent)
        }

        if (bd.hayListas()) {
            binding.txtNoHayListas.isVisible = false
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

    val actualizarListas =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (bd.hayListas()) {
                binding.txtNoHayListas.isVisible = false
                configurarRecycler()
            } else {
                binding.txtNoHayListas.isVisible = true
            }
        }

    private fun configurarRecycler() {
        adaptador = ListasAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 1)
        consultaListas()
        binding.recyclerListas.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaListas() {
        val myAsyncTask = MyAsyncTask().execute()
    }

    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<ListaCompra>>() {
        override fun doInBackground(vararg params: Void?): MutableList<ListaCompra> {
            return bd.consultaListas()
        }

        override fun onPostExecute(result: MutableList<ListaCompra>) {
            super.onPostExecute(result)
            adaptador.setListas(result)
        }
    }

    companion object{
        const val LISTA = "lista"
    }

    override fun onClickListener(lista: ListaCompra) {
        val intent = Intent(this, InfoListaCompra::class.java)
        intent.putExtra(LISTA, lista)
        startActivity(intent)
    }

    override fun onLongClickListener(lista: ListaCompra) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(Html.fromHtml("<b>Confirmación<b>"))
        builder.setIcon(android.R.drawable.stat_notify_error)
        builder.setMessage("\n¿Desea eliminar esta lista?")
        // Si aceptas el mensaje se elimina la lista
        builder.setPositiveButton("Aceptar") { _, _ ->
            bd.eliminarLista(lista.denominacion)

            Snackbar.make(binding.root, "Eliminado correctamente!", Snackbar.LENGTH_LONG).show()
            configurarRecycler()

            if (!bd.hayListas())
                binding.txtNoHayListas.isVisible = true
        }
        // Si cancelas el permiso se cierra esa ventana
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }
}