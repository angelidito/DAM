package com.martinezangel.bd3.activities

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.martinezangel.bd3.bd.ComprasDAO
import com.martinezangel.bd3.enventlisteners.ListaProductoEventListener
import com.google.android.material.snackbar.Snackbar
import android.text.InputType

import android.widget.EditText
import androidx.core.text.isDigitsOnly
import com.martinezangel.bd3.adapters.ListaProductoAdapter
import com.martinezangel.bd3.databinding.ActivityDatosListaBinding
import com.martinezangel.bd3.models.Lista
import com.martinezangel.bd3.models.ListaProducto


class DatosListaActivity : AppCompatActivity(), ListaProductoEventListener {
    private lateinit var binding: ActivityDatosListaBinding
    private lateinit var adaptador: ListaProductoAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var lista: Lista
    private lateinit var database: ComprasDAO

    companion object {
        const val LISTA = "lista"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = ComprasDAO(this)
        lista = intent.getParcelableExtra(ListaActivity.LISTA)!!

        binding.ttlListaCompra.text = lista.denominacion

        configurarRecycler()

        binding.btnAAdirProductoLista.setOnClickListener {
            intent = Intent(this, AnadirProductoAListaActivity::class.java)
            intent.putExtra(LISTA, lista)
            actualizarLista.launch(intent)
        }
    }

    private val actualizarLista =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            configurarRecycler()
        }

    private fun configurarRecycler() {
        adaptador = ListaProductoAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)

        CargaProductosAsyncTask().execute()

        binding.recyclerListaProductos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private inner class CargaProductosAsyncTask() :
        AsyncTask<Void, Void, MutableList<ListaProducto>>() {
        override fun doInBackground(vararg params: Void?): MutableList<ListaProducto> {

            return database.getProductosFromLista(lista.codigoLista)
        }

        override fun onPostExecute(result: MutableList<ListaProducto>) {
            super.onPostExecute(result)
            val nombresProducto :ArrayList<String> = ArrayList()
            for(lp in result){
                nombresProducto.add(database.getProducto(lp.codigoProducto)!!.denominacion)
            }
            adaptador.setNombresProductos(nombresProducto)
            adaptador.setProductos(result)
        }
    }

    override fun onClickListener(listaProducto: ListaProducto) {
        val builder = AlertDialog.Builder(this)
        val input = EditText(this)

        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setTitle("Introduzca la cantidad.")
        builder.setView(input)

        builder.setPositiveButton("Aceptar") { _, _ ->
            val cantidad = input.text.toString()
            if (cantidad.isNullOrBlank() || !cantidad.isDigitsOnly()) {
                Snackbar.make(binding.root, "No ha introducido una cantidad.", Snackbar.LENGTH_LONG)
                    .show()
                return@setPositiveButton
            }

            database.updateCantidadProductoFromLista(
                listaProducto.codigoLista,
                listaProducto.codigoProducto,
                cantidad
            )
            Snackbar.make(binding.root, "Actualizado.", Snackbar.LENGTH_LONG).show()
            configurarRecycler()
        }
        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }
        builder.show()
    }

    override fun onLongClickListener(listaProducto: ListaProducto) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("¿Eliminar producto de la lista?")
        builder.setPositiveButton("Eliminar") { _, _ ->
            database.deleteProductoFromLista(
                listaProducto.codigoProducto,
                listaProducto.codigoLista
            )
            Snackbar.make(binding.root, "Producto eliminado de la lista.", Snackbar.LENGTH_LONG).show()
            configurarRecycler()
        }
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }
}