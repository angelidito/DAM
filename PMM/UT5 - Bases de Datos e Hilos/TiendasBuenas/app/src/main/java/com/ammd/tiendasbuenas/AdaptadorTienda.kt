package com.ammd.tiendasbuenas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammd.tiendasbuenas.databinding.ItemStoreBinding

class AdaptadorTienda(
    private var tiendas: MutableList<Tienda>,
    private var listener: EventosListener
) : RecyclerView.Adapter<AdaptadorTienda.ViewHolder>() {

    private lateinit var contexto: Context

    inner class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemStoreBinding.bind(view)

        fun setListener(tienda: Tienda) {
            with(binding.root) {
                setOnClickListener() { listener.editar(tienda.id) }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_store, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var tienda = tiendas.get(position)
        with(holder) {
            setListener(tienda)
            binding.tvName.text = tienda.nombre
            if (tienda.esFavorito == 0)
                binding.cbFavorite.isChecked = false
            else
                binding.cbFavorite.isChecked = true

        }
    }

    override fun getItemCount(): Int = tiendas.size

    fun add(tienda: Tienda) {
        tiendas.add(tienda)
        notifyDataSetChanged()
    }

    fun setTiendas(tiendas: MutableList<Tienda>) {
        this.tiendas = tiendas
        notifyDataSetChanged()
    }
}