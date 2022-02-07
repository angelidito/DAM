package com.example.bd3delgadosergio.Pojos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bd3delgadosergio.R
import com.example.bd3delgadosergio.databinding.ItemCategoriaBinding
import com.example.bd3delgadosergio.EventosListener.EventosListener3

class ListasAdapter (private var listas: MutableList<ListaCompra>, private var listener: EventosListener3)
    : RecyclerView.Adapter<ListasAdapter.ViewHolder>() {

    private lateinit var contexto: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCategoriaBinding.bind(view)
        fun setListener(listaCompra: ListaCompra) {
            binding.root.setOnClickListener {
                listener.onClickListener(listaCompra)
            }
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(listaCompra)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listaCompra = listas.get(position)
        with(holder) {
            setListener(listaCompra)
            binding.nombreCategoria.text = listaCompra.denominacion
        }
    }

    override fun getItemCount(): Int = listas.size

    fun setListas(listas: MutableList<ListaCompra>) {
        this.listas = listas
        notifyDataSetChanged()
    }
}