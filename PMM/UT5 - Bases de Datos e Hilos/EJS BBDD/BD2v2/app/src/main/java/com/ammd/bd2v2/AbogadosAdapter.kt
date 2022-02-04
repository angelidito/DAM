package com.ammd.bd2v2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammd.bd2v2.databinding.ActivityCasoItemBinding

class AbogadosAdapter(
	private var casos: MutableList<Caso>,
	private var listener: EventosListener
) : RecyclerView.Adapter<AbogadosAdapter.ViewHolder>() {

	private lateinit var context: Context

	inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

		val binding = ActivityCasoItemBinding.bind(view)

		fun setListener(caso: Caso) {
			with(binding.root) {
				setOnClickListener { listener.mostrarCaso(caso.numeroCaso) }
				setOnLongClickListener {
					listener.marcarComoRealizado(caso.numeroCaso)
					true
				}
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		context = parent.context

		val view = LayoutInflater.from(context)
			.inflate(
				R.layout.activity_caso_item,
				parent,
				false
			)

		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val caso = casos.get(position)
		with(holder) {
			setListener(caso)
			binding.numeroCaso.text = caso.numeroCaso
			binding.denominacion.text = caso.denominacion
		}
	}

	override fun getItemCount(): Int = casos.size

	fun add(caso: Caso) {
		casos.add(caso)
		notifyDataSetChanged()
	}

	fun setCasos(casos: MutableList<Caso>) {
		this.casos = casos
		notifyDataSetChanged()
	}

	fun update(caso: Caso) {
		val index = casos.indexOf(caso)
		if (index != -1) {
			casos[index] = caso
			notifyItemChanged(index)
		}
	}


}
