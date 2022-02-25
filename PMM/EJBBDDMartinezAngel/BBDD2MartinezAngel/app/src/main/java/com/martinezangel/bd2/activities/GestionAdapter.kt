package com.martinezangel.bd2.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.martinezangel.bd2.R
import com.martinezangel.bd2.databinding.GestionItemBinding
import com.martinezangel.bd2.eventlisteners.InfoCasoEventListener
import com.martinezangel.bd2.models.Gestion


class GestionAdapter(
	private var gestiones: MutableList<Gestion>,
	private var listener: InfoCasoEventListener
) : RecyclerView.Adapter<GestionAdapter.ViewHolder>() {

	private lateinit var contexto: Context

	inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val binding = GestionItemBinding.bind(view)
		fun setListener(gestion: Gestion) {
			binding.root.setOnLongClickListener {
				listener.onLongClickListener(gestion)
				true
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		contexto = parent.context
		val view = LayoutInflater.from(contexto).inflate(R.layout.gestion_item, parent, false)
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