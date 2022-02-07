package com.ppsg.bd2saucopedropablo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ppsg.bd2saucopedropablo.databinding.CaratulaCasoBinding

class AdaptadorBufete(
    private var cas: MutableList<Casos>, private var listener: EventosListener
) : RecyclerView.Adapter<AdaptadorBufete.ViewHolder>() {
    private lateinit var contexto: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = CaratulaCasoBinding.bind(view)

        fun setListener(casos: Casos) {
            binding.card.setOnClickListener {
                listener.mostrarDetalles(casos)
                binding.card.isChecked = !binding.card.isChecked
                true
            }
            with(binding.root) {
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.caratula_caso, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdaptadorBufete.ViewHolder, position: Int) {
        val caso = cas.get(position)
        with(holder) {
            setListener(caso)
            binding.titulo.text = "CASO " + caso.denominacion
            binding.numeroCaso.text = "Nº caso: " + caso.numeroCaso
            binding.denominacion.text = "El nombre del caso es: " + caso.denominacion
        }
    }

    override fun getItemCount(): Int = cas.size
    fun add(casos: Casos) {
        cas.add(casos)
        notifyDataSetChanged()
    }

    fun  setAlojamientos(casos: MutableList<Casos>){
        this.cas=casos
        notifyDataSetChanged()
    }
}

//    override fun getItemCount(): Int = portales.size
//    fun add(portal: Portal) {
//        portales.add(portal)
//        notifyDataSetChanged()
//    }
//    fun  setAlojamientos(alojamientos: MutableList<Portal>){
//        this.portales=alojamientos
//        notifyDataSetChanged()
//    }
//}