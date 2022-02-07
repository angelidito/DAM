package com.ima.maesoivan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ima.maesoivan.databinding.ItemEspAltBinding

class EspecialidadAdapter(private val esps:List<Especialidad>, private val listener:Eventoslistener):RecyclerView.Adapter<EspecialidadAdapter.ViewHolder>() {
    private lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_esp_alt, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val esp = esps.get(position)
        with(holder) {
            setListener(esp, (position + 1))
            binding.codEsp.text = esp.codigo()
            binding.nomEsp.text = esp.nombre()
            binding.AnnEsp.text = esp.annos()
            binding.ordenMon.text = (position + 1).toString()
        }
    }

    override fun getItemCount(): Int = esps.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemEspAltBinding.bind(view)
        fun setListener(esp: Especialidad, posicion: Int) {
            binding.root.setOnLongClickListener { listener.onLongClickListener(esp, posicion);true }
        }
    }
}