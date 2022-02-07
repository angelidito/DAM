package com.example.bd2delgadosergio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bd2delgadosergio.databinding.ItemCasoBinding

class CasoAdapter (private var casos: MutableList<Caso>, private var listener: EventosListener)
    : RecyclerView.Adapter<CasoAdapter.ViewHolder>() {

    private lateinit var contexto: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCasoBinding.bind(view)
        fun setListener(caso: Caso) {
            binding.root.setOnClickListener {
                listener.onClickListener(caso)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CasoAdapter.ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_caso, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CasoAdapter.ViewHolder, position: Int) {
        val caso = casos.get(position)
        with(holder) {
            setListener(caso)
            binding.nombreCaso.text = caso.denominacion
            binding.numeroCaso.text = caso.numCaso.toString()
        }
    }

    override fun getItemCount(): Int = casos.size

    fun setCasos(casos: MutableList<Caso>) {
        this.casos = casos
        notifyDataSetChanged()
    }
}