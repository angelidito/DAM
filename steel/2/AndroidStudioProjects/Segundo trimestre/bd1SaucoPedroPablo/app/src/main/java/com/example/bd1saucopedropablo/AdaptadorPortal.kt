package com.example.bd1saucopedropablo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.bd1saucopedropablo.databinding.CaratulaHotelBinding

class AdaptadorPortal(
    private var portales: MutableList<Portal>, private var listener: EventosListener
) : RecyclerView.Adapter<AdaptadorPortal.ViewHolder>() {
    private lateinit var contexto: Context


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CaratulaHotelBinding.bind(view)
        fun setListener(portal: Portal) {
            binding.card.setOnLongClickListener {
                listener.mostrarDetalles(portal)
                binding.card.isChecked = !binding.card.isChecked
                true
            }
            binding.cbFavorite.setOnClickListener {
                listener.onFavorito(portal)
            }
            with(binding.root) {
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.caratula_hotel, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdaptadorPortal.ViewHolder, position: Int) {
        val portal = portales.get(position)
        with(holder) {
            setListener(portal)
            binding.nombre.text = portal.denominacion
            binding.localidad.text = "Localidad: "+portal.localidad
            binding.precio.text ="El precio por persona es: " +portal.precio.toString()+"€"
            Glide.with(binding.root)
                .load(portal?.imagen)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imagen)
        }
    }

    override fun getItemCount(): Int = portales.size
    fun add(portal: Portal) {
        portales.add(portal)
        notifyDataSetChanged()
    }
    fun  setAlojamientos(alojamientos: MutableList<Portal>){
        this.portales=alojamientos
        notifyDataSetChanged()
    }

    //AGREGAR UN HOTEL A FAVORITO
    fun update(portal: Portal){
        val index =portales.indexOf(portal)
        if(index != -1){
            portales[index]=portal
            notifyItemChanged(index)
        }
    }

}
