package com.sde.bd1delgadosergio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sde.bd1delgadosergio.databinding.ItemLocalidadBinding

class AlojamientoAdapter(private var alojamientos: MutableList<Alojamiento>, private var listener: EventosListener)
    : RecyclerView.Adapter<AlojamientoAdapter.ViewHolder>() {

    private lateinit var contexto: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemLocalidadBinding.bind(view)
        fun setListener(alojamiento: Alojamiento) {
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(alojamiento)
                true
            }
            binding.crznFavorito.setOnClickListener {
                listener.onFavorito(alojamiento)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlojamientoAdapter.ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_localidad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlojamientoAdapter.ViewHolder, position: Int) {
        val alojamiento = alojamientos.get(position)
        with(holder) {
            setListener(alojamiento)
            Glide.with(binding.root).load(alojamiento.imagen).diskCacheStrategy(DiskCacheStrategy.ALL).into(binding.imgAlojamiento)
            binding.nombreAlojamiento.text = alojamiento.nombre
            binding.localidadAlojamiento.text = alojamiento.localidad
            binding.precioAlojamiento.text = alojamiento.precio.toString() + "€ persona / noche"
        }
    }

    override fun getItemCount(): Int = alojamientos.size

    fun add(alojamiento: Alojamiento) {
        alojamientos.add(alojamiento)
        notifyDataSetChanged()
    }

    fun setAlojamientos(alojamientos: MutableList<Alojamiento>) {
        this.alojamientos = alojamientos
        notifyDataSetChanged()
    }

    fun update(alojamiento: Alojamiento) {
        val index = alojamientos.indexOf(alojamiento)
        if (index != -1) {
            alojamientos.set(index, alojamiento)
            notifyItemChanged(index)
        }
    }
}