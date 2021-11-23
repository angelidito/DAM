package com.ammd.martinezangel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammd.martinezangel.databinding.EspecialidadItemBinding

class EspecialidadAdapter(
    private val especialidades: List<Especialidad>,
    private val listener: EventosListener
) :
    RecyclerView.Adapter<EspecialidadAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.especialidad_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val especialidad = especialidades[position]
        with(holder) {
            setListener(especialidad.code, especialidad.limitYear)
            binding.codeName.text = "" + especialidad.code + " - " + especialidad.name
            binding.years.text = "Límite de años: " + especialidad.limitYear
        }
    }


    override fun getItemCount(): Int = especialidades.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = EspecialidadItemBinding.bind(view)
        fun setListener(especialidad: Int, years: Int) {
            binding.especialidadItem.setOnLongClickListener() {
                listener.onLongClickListenerCall(especialidad, years)
                true
            }
        }
    }
}