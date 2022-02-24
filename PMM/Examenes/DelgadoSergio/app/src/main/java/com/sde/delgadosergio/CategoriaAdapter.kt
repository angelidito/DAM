package com.sde.delgadosergio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sde.delgadosergio.databinding.ItemCategoriaBinding

class CategoriaAdapter (private var categorias: MutableList<Categoria>, private var listener: EventosListener)
    : RecyclerView.Adapter<CategoriaAdapter.ViewHolder>() {

    private lateinit var contexto: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCategoriaBinding.bind(view)
        fun setListener(categorias: Categoria) {
            binding.root.setOnClickListener {
                listener.onClickListener(categorias)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_categoria, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoria = categorias.get(position)
        with(holder) {
            setListener(categoria)
            binding.nombreCategoria.text = categoria.denominacion
        }
    }

    override fun getItemCount(): Int = categorias.size

    fun setCategorias(eventos: MutableList<Categoria>) {
        this.categorias = eventos
        notifyDataSetChanged()
    }
}