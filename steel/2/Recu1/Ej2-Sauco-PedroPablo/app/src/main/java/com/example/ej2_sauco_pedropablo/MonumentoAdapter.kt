package com.example.ej2_sauco_pedropablo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ej2_sauco_pedropablo.databinding.CaratulaMonumentosBinding

class MonumentoAdapater(private val monumentos: List<Monumento>,private val list: EventosListener) :
    RecyclerView.Adapter<MonumentoAdapater.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.caratula_monumentos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = monumentos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val monumento = monumentos.get(position)
        with(holder) {
            binding.titulo.text = monumento.nombre
            binding.ubicacion.text = monumento.ubicacion
            setEventos(monumento)
            Glide.with(context)
                .load(monumento.imagen)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imagen)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CaratulaMonumentosBinding.bind(view)
        fun setEventos(monumento: Monumento) {
            binding.botonLlamar.setOnClickListener {
                list.llamarEvento(monumento)
            }
            binding.botonMensaje.setOnClickListener {
                list.correoEvento(monumento)
            }
            binding.card.setOnLongClickListener {
                list.mostrarDetalles(monumento)
                binding.card.isChecked = !binding.card.isChecked
                true
            }
        }
    }
}
