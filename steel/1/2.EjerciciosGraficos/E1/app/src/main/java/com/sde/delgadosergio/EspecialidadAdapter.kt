package com.sde.delgadosergio


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sde.delgadosergio.databinding.ActivityInfoCadaEspecialidadBinding

class EspecialidadAdapter(private val especialidades: List<Especialidad>, val listener:EventosListener): RecyclerView.Adapter<EspecialidadAdapter.ViewHolder>(){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.activity_info_cada_especialidad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val especialidad = especialidades[position]
        with(holder){
            setListener(especialidad)
            binding.nombreEspecialidad.text = especialidades[position].nombre
            binding.codigoEspecialidad.text = especialidades[position].codigo.toString()
            binding.annosMinimos.text = especialidades[position].annosMinimos.toString()
        }
    }

    override fun getItemCount(): Int = especialidades.size

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ActivityInfoCadaEspecialidadBinding.bind(view)
        fun setListener(especialidad:Especialidad){
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(especialidad)
                true
            }
        }
    }
}