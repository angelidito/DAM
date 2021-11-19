package com.ammd.a2monumentos

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ammd.a2monumentos.databinding.MonumentoItemBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MonumentoAdapter(
    private val monumentos: List<Monumento>,
    private val listener: EventosListener
) :
    RecyclerView.Adapter<MonumentoAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.monumento_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val monumento = monumentos.get(position)
        with(holder) {
            setListener(monumento, position)
            Glide.with(context)
                .load(monumento.imagen)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop()
                .into(holder.binding.imagenMonumento)
            binding.denominacionMonumento.text = monumento.denominacion
            binding.ubicacionMonumento.text = monumento.ubicacion
        }

    }


    override fun getItemCount(): Int = monumentos.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = MonumentoItemBinding.bind(view)
        fun setListener(monumento: Monumento, posicion: Int) {
            binding.callphoneBtn.setOnClickListener {
                listener.onClickListenerCall(monumento, posicion)
            }
            binding.emailBtn.setOnClickListener {
                listener.onClickListenerEmail(monumento, posicion)
            }
        }
    }
}