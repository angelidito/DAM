package com.ppsg.ejbasesdedatos1


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ppsg.ejbasesdedatos1.databinding.ItemStoreBinding

class AdaptadorTienda(
    private var tiendas: MutableList<Tienda>,
    private var listener: EventosListener
) : RecyclerView.Adapter<AdaptadorTienda.ViewHolder>() {
    private lateinit var contexto: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemStoreBinding.bind(view)
        fun setListener(tienda:Tienda) {

            with(binding.root) {
                setOnClickListener { listener.editar(tienda.id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto=parent.context
        val view= LayoutInflater.from(contexto).inflate(R.layout.item_store,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tienda=tiendas.get(position)
        with(holder){
            setListener(tienda)
            binding.tvName.text=tienda.name
            binding.cbFavorite.isChecked=tienda.esFavorito.equals(0)
        }
        //holder.binding.cbFavorite.isChecked=tienda.esFavorito.equals(0)
        //holder.binding.tvName.text=tienda.name
    }

    override fun getItemCount(): Int = tiendas.size
}