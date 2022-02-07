package com.example.ej2delgadosergio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ej2delgadosergio.databinding.ItemMonumentoBinding

class MonumentoAdapter(private val monumentos: List<Monumento>, val listener:EventosListener):RecyclerView.Adapter<MonumentoAdapter.ViewHolder>(){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_monumento, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val monumento = monumentos[position]
        with(holder){
            setListener(monumento)
            binding.nombreMonumento.text = monumentos[position].nombre
            binding.ubicacionMonumento.text = monumentos[position].ubicacion
            Glide.with(context).load(monumento.imagen).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.binding.imgPhoto)
        }
    }

    override fun getItemCount(): Int = monumentos.size

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ItemMonumentoBinding.bind(view)
        fun setListener(monumento:Monumento){
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(monumento)
                true
            }

            binding.btnLlamar.setOnClickListener {listener.onClickLlamar(monumento) }

            binding.btnEmail.setOnClickListener {listener.onClickEmail(monumento) }
        }
    }
}