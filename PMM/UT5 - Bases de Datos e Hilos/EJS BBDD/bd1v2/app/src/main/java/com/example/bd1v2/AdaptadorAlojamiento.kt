package com.example.bd1v2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bd1v2.databinding.ActivityModeloAlojamientoBinding

class AdaptadorAlojamiento(private var alojamientos: MutableList<Alojamiento>, private var listener: EventosListener)
    :RecyclerView.Adapter<AdaptadorAlojamiento.ViewHolder>(){
    private lateinit var contexto: Context
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding=ActivityModeloAlojamientoBinding.bind(view)
        fun setListener(alojamiento: Alojamiento){
            with(binding.root){
                setOnClickListener {listener.editar(alojamiento.id)}
                setOnLongClickListener {
                    listener.borrarTienda(alojamiento.id)
                    true
                }
            }
            binding.cbFavorito.setOnClickListener {
                listener.favorito(alojamiento)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto=parent.context
        val view= LayoutInflater.from(contexto).inflate(R.layout.activity_modelo_alojamiento,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alojamiento=alojamientos.get(position)
        with(holder){
            setListener(alojamiento)
            binding.tvDenominacion.text=alojamiento.denominacion
            binding.cbFavorito.isChecked=alojamiento.esFavorito.equals(0)
        }
    }

    override fun getItemCount(): Int=alojamientos.size
    fun add(alojamiento: Alojamiento) {
        alojamientos.add(alojamiento)
        notifyDataSetChanged()
    }
    fun  setAlojamientos(alojamientos: MutableList<Alojamiento>){
        this.alojamientos=alojamientos
        notifyDataSetChanged()
    }

    fun update(alojamiento: Alojamiento) {
        val index=alojamientos.indexOf(alojamiento)
        if(index!=-1) {
            alojamientos.set(index, alojamiento)
            notifyItemChanged(index)
        }
    }

    fun borrar(id: Int) {
        val tienda=Alojamiento(id, "", 0,0)
        val index=alojamientos.indexOf(tienda)
        if(index!=-1) {
            alojamientos.removeAt(index)
            notifyItemRemoved(index)
        }
    }
}