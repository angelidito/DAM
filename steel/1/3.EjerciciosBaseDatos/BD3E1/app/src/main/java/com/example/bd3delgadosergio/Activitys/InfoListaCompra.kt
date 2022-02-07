package com.example.bd3delgadosergio.Activitys

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bd3delgadosergio.BD.ListaDAO
import com.example.bd3delgadosergio.EventosListener.EventosListener4
import com.example.bd3delgadosergio.Pojos.*
import com.example.bd3delgadosergio.databinding.ActivityInfoListaCompraBinding
import com.google.android.material.snackbar.Snackbar
import android.text.InputType

import android.widget.EditText
import androidx.core.text.isDigitsOnly


class InfoListaCompra: AppCompatActivity(), EventosListener4 {
    private lateinit var binding: ActivityInfoListaCompraBinding
    private lateinit var adaptador: ProductoAdapterLista
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var lista: ListaCompra
    private lateinit var bd: ListaDAO

    companion object{
        const val LISTA = "lista"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoListaCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = ListaDAO(this)

        lista = intent.getParcelableExtra(ListaCompraActivity.LISTA)!!

        binding.tituloNombreLista.text = lista.denominacion

        binding.btnAddProductoLista.setOnClickListener {
            intent = Intent(this, AddProductoListaActivity::class.java)
            intent.putExtra(LISTA, lista)
            actualizarLista.launch(intent)
        }

        if (bd.tieneProductosLista(lista.idLista)) {
            binding.txtNoHayProductos.isVisible = false
            configurarRecycler()
        }
    }

    val actualizarLista =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            configurarRecycler()

            if (bd.tieneProductosLista(lista.idLista))
                binding.txtNoHayProductos.isVisible = false
        }

    private fun configurarRecycler() {
        adaptador = ProductoAdapterLista(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)
        consultaProductosLista()
        binding.recyclerProductos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaProductosLista() {
        val myAsyncTask = MyAsyncTask().execute()
    }

    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<ListaProducto>>() {
        override fun doInBackground(vararg params: Void?): MutableList<ListaProducto> {
            return bd.consultaProductosLista(lista.idLista)
        }

        override fun onPostExecute(result: MutableList<ListaProducto>) {
            super.onPostExecute(result)
            adaptador.setProductos(result)
        }
    }

    override fun onClickListener(listaProducto: ListaProducto) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Introduzca la nueva cantidad")

        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("Aceptar") { dialog, which ->
            val nuevaCantidad = input.text.toString()
            if (nuevaCantidad != ""){
                if (nuevaCantidad.isDigitsOnly()){
                    bd.actualizarCantidad(listaProducto.codLista, listaProducto.codProd, nuevaCantidad)
                    Snackbar.make(binding.root, "Cantidad actualizada correctamente!", Snackbar.LENGTH_LONG).show()
                    configurarRecycler()
                }
                else {
                    Snackbar.make(binding.root, "Cantidad no válida", Snackbar.LENGTH_LONG).show()
                }
            }
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.cancel()
        }

        builder.show()
    }

    override fun onLongClickListener(listaProducto: ListaProducto) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(Html.fromHtml("<b>Confirmación<b>"))
        builder.setIcon(android.R.drawable.stat_notify_error)
        builder.setMessage("\n¿Desea eliminar este producto de la lista?")
        // Si aceptas el mensaje se elimina la lista
        builder.setPositiveButton("Aceptar") { _, _ ->
            bd.eliminarProductoLista(listaProducto.codProd, listaProducto.codLista)

            Snackbar.make(binding.root, "Eliminado correctamente!", Snackbar.LENGTH_LONG).show()
            configurarRecycler()

            if (!bd.tieneProductosLista(listaProducto.codLista))
                binding.txtNoHayProductos.isVisible = true
        }
        // Si cancelas el permiso se cierra esa ventana
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }
}