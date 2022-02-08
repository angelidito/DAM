package com.example.bd2E1ds

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bd2E1ds.R
import com.example.bd2E1ds.databinding.ItemGestionBinding

class GestionAdapter (private var gestiones: MutableList<Gestion>, private var listener: EventosListener2)
    : RecyclerView.Adapter<GestionAdapter.ViewHolder>() {

    private lateinit var contexto: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemGestionBinding.bind(view)
        fun setListener(gestion: Gestion) {
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(gestion)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_gestion, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gestion = gestiones.get(position)
        with(holder) {
            setListener(gestion)
            binding.descripcionGestion.text = gestion.descripcion
            binding.fechaGestion.text = gestion.fecha
        }
    }

    override fun getItemCount(): Int = gestiones.size

    fun setGestion(gestiones: MutableList<Gestion>) {
        this.gestiones = gestiones
        notifyDataSetChanged()
    }
}