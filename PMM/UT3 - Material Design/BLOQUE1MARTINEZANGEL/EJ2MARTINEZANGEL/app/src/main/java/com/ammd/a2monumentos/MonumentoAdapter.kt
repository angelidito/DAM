package com.ammd.a2monumentos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammd.a2monumentos.databinding.MontumentoItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MonumentoAdapter(private val monumentos:List<Monumento>)
    : RecyclerView.Adapter<MonumentoAdapter.ViewHolder>() {

    private lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.montumento_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val monumento = monumentos.get(position)
        with(holder){
            setListener(monumento, position+1)
//            binding.denominacionMonumento.text = monumento.denominacion
            Glide.with(context)
                .load(monumento.imagen)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop()
                .into(holder.binding.imagenMonumento)
        }
    }

    override fun getItemCount(): Int = monumentos.size
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val binding = MontumentoItemBinding.bind(view)
        fun setListener (monumento: Monumento, posicion: Int){
            binding.root.setOnClickListener{
            }
        }
    }
}