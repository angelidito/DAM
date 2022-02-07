package com.ppsg.saucopedropablo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.ppsg.saucopedropablo.databinding.CaratulaEspecialidadBinding

class EspecialidadAdapter(private val especialidades: List<Especialidad>, private val list: Informacion) :
    RecyclerView.Adapter<EspecialidadAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.caratula_especialidad, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = especialidades.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val especialidad = especialidades.get(position)
        with(holder) {
            binding.txtCodigo.text = "Código de especialidad:" + especialidad.codigo.toString()
            binding.txtNombre.text = especialidad.nombre
            binding.txtAnnos.text = "Años necesarios: " + especialidad.annos.toString()
            setEventos(especialidad)

        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CaratulaEspecialidadBinding.bind(view)
        fun setEventos(especialidad: Especialidad) {
            binding.card.setOnLongClickListener {
                binding.card.isChecked = !binding.card.isChecked
                true

            }
        }
    }
}