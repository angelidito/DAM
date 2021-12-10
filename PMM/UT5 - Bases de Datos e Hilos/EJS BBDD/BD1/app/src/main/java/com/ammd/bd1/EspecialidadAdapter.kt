package com.ammd.bd1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammd.bd1.databinding.AlojamientoItemBinding

class EspecialidadAdapter(private val listaAlojamientos:List<Alojamiento>, private val listener:Eventoslistener):RecyclerView.Adapter<EspecialidadAdapter.ViewHolder>() {
    private lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.activity_buscador, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val esp = listaAlojamientos.get(position)
        with(holder) {
            setListener(esp, (position + 1))
            binding.denominacion.text= esp.denominacion
            binding.precio.text = esp.precio.toString()
            binding.localidad.text= esp.localidad
        }
    }

    override fun getItemCount(): Int = listaAlojamientos.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = AlojamientoItemBinding.bind(view)
        fun setListener(esp: Alojamiento, posicion: Int) {
            binding.root.setOnLongClickListener { listener.onLongClickListener(esp, posicion);true }
        }
    }
}