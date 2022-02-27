package com.martinezangel.bd3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.martinezangel.bd3.R
import com.martinezangel.bd3.databinding.ItemCategoriaBinding
import com.martinezangel.bd3.enventlisteners.ListaEventListener
import com.martinezangel.bd3.models.Lista

class ListaAdapter(
    private var listas: MutableList<Lista>,
    private var listener: ListaEventListener
) : RecyclerView.Adapter<ListaAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCategoriaBinding.bind(view)
        fun setClickListeners(lista: Lista) {
            binding.root.setOnClickListener {
                listener.onClickListener(lista)
            }
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(lista)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lista = listas[position]
        with(holder) {
            setClickListeners(lista)
            binding.denominacion.text = lista.denominacion
        }
    }

    override fun getItemCount(): Int = listas.size

    fun setListas(listas: MutableList<Lista>) {
        this.listas = listas
        notifyDataSetChanged()
    }
}