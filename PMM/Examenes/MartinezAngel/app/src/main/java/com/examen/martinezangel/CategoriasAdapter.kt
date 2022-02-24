package com.ammd.martinezangel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.examen.martinezangel.Categoria
import com.examen.martinezangel.R
import com.examen.martinezangel.databinding.CategoriaItemBinding

class CategoriasAdapter(
    private var categorias: MutableList<Categoria>,
    private val listener: EventosListener
) :
    RecyclerView.Adapter<CategoriasAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.categoria_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoria = categorias[position]
        with(holder) {
            setListener(categoria.codigoCategoria)
            binding.textoCategoria.text =
                "" + categoria.codigoCategoria + " - " + categoria.denominacion
        }
    }


    override fun getItemCount(): Int = categorias.size

    fun setCategorias(listaCategorias: MutableList<Categoria>) {
        this.categorias = listaCategorias
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CategoriaItemBinding.bind(view)
        fun setListener(codigoCategoria: Int) {
            binding.especialidadItem.setOnClickListener() {
                listener.onClickListenerCall(codigoCategoria)
            }
        }
    }
}