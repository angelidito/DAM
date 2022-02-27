package com.martinezangel.bd3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.martinezangel.bd3.R
import com.martinezangel.bd3.databinding.ItemCategoriaBinding
import com.martinezangel.bd3.enventlisteners.CategoriaEventListener
import com.martinezangel.bd3.models.Categoria

class CategoriaAdapter(
    private var categorias: MutableList<Categoria>,
    private var listener: CategoriaEventListener
) : RecyclerView.Adapter<CategoriaAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCategoriaBinding.bind(view)
        fun setClickListeners(categoria: Categoria) {
            binding.root.setOnClickListener {
                listener.onClickListener(categoria)
            }
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(categoria)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_categoria, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoria = categorias[position]
        with(holder) {
            setClickListeners(categoria)
            binding.denominacion.text = categoria.denominacion
        }
    }

    override fun getItemCount(): Int = categorias.size

    fun setCategorias(categorias: MutableList<Categoria>) {
        this.categorias = categorias
        notifyDataSetChanged()
    }
}