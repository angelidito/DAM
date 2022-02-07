package com.example.recsaucopedropablo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recsaucopedropablo.databinding.CaratulaCocheBinding

class VehiculoAdapter(
    private val vehiculos: List<Vehiculo>,
    private val listener: EventosListener
) : RecyclerView.Adapter<VehiculoAdapter.ViewHolder>(){
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(context).inflate(R.layout.caratula_coche, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = vehiculos.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vehiculo = vehiculos.get(position)
        with(holder) {
            binding.dni.text = vehiculo.dni
            binding.nombre.text = vehiculo.nombre
            binding.matricula.text = vehiculo.matricula
            binding.modelo.text = vehiculo.modelo
            binding.fecha.text = vehiculo.fecha
            //binding.estado.text = vehiculo.estado.toString()
            setEventos(vehiculo, (position + 1))
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CaratulaCocheBinding.bind(view)
        fun setEventos(vehiculo: Vehiculo, posicion: Int) {
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(vehiculo, posicion);true
            }
            binding.root.setOnClickListener {
                listener.onClickListener(vehiculo, posicion);true
            }

        }
    }
}