package com.martinezangel.bd2.activities


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.martinezangel.bd2.R
import com.martinezangel.bd2.databinding.CasoItemBinding
import com.martinezangel.bd2.eventlisteners.EventosListener
import com.martinezangel.bd2.models.Caso

class CasoAdapter(private var casos: MutableList<Caso>, private var listener: EventosListener) :
    RecyclerView.Adapter<CasoAdapter.ViewHolder>() {

    private lateinit var contexto: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CasoItemBinding.bind(view)
        fun setListener(caso: Caso) {
            binding.root.setOnClickListener {
                listener.onClickListener(caso)
            }
        }
    }

    override fun getItemCount(): Int = casos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.caso_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val caso = casos[position]
        with(holder) {
            setListener(caso)
            binding.denominacionCaso.text = caso.denominacion
            binding.numeroCaso.text = caso.numeroCaso
        }
    }

    fun setCasos(casos: MutableList<Caso>) {
        this.casos = casos
        notifyDataSetChanged()
    }
}