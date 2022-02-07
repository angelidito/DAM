package com.example.pedropaexamenprueba

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pedropaexamenprueba.databinding.CaratulaEspecialidadBinding

class EspecialidadAdapter(
    private val especialidades: List<Especialidad>,
    private val listener: EventosListener
) : RecyclerView.Adapter<EspecialidadAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(context).inflate(R.layout.caratula_especialidad, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = especialidades.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val especialidad = especialidades.get(position)
        with(holder) {
            binding.nombreEspecialidad.text = especialidad.nombre
            binding.codEspecialidad.text = especialidad.codigo.toString()
            binding.annosNecesarios.text = especialidad.annos.toString()
            setEventos(especialidad, (position + 1))
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CaratulaEspecialidadBinding.bind(view)
        fun setEventos(especialidad: Especialidad, posicion: Int) {
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(especialidad, posicion);true
            }
        }
    }
}
