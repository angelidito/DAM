package com.example.bd3delgadosergio.Pojos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bd3delgadosergio.EventosListener.EventosListener4
import com.example.bd3delgadosergio.R
import com.example.bd3delgadosergio.databinding.ItemProductoListaBinding

class ProductoAdapterLista (private var listaProductos: MutableList<ListaProducto>, private var listener: EventosListener4)
    : RecyclerView.Adapter<ProductoAdapterLista.ViewHolder>() {

    private lateinit var contexto: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemProductoListaBinding.bind(view)
        fun setListener(listaProducto: ListaProducto) {
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(listaProducto)
                true
            }
            binding.root.setOnClickListener {
                listener.onClickListener(listaProducto)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_producto_lista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listaProducto = listaProductos.get(position)
        with(holder) {
            setListener(listaProducto)
            binding.nombreProducto.text = listaProducto.codProd.toString()
            binding.cantidadProducto.text = "Cantidad: " + listaProducto.cantidad.toString()
        }
    }

    override fun getItemCount(): Int = listaProductos.size

    fun setProductos(listaProductos: MutableList<ListaProducto>) {
        this.listaProductos = listaProductos
        notifyDataSetChanged()
    }
}