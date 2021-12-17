package com.ammd.bd1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ammd.bd1.databinding.AlojamientoItemBinding

class AlojamientosAdapter(
	private var alojamientos: MutableList<Alojamientos>,
	private var listener: Eventoslistener
) : RecyclerView.Adapter<AlojamientosAdapter.ViewHolder>() {

	private lateinit var context: Context

	inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		var binding = AlojamientoItemBinding.bind(view)

		fun setListener(alojamiento: Alojamientos) {
			with(binding.root) {
				setOnLongClickListener {
					listener.openAlojamiento(alojamiento.codigo_alojamiento)
					true
				}
				binding.cardCbFavorite.setOnClickListener {
					listener.onFavorito(alojamiento)
				}
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		context = parent.context
		val view = LayoutInflater.from(context).inflate(R.layout.alojamiento_item, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val esp = alojamientos[position]
		with(holder) {
//			setListener(esp, (position + 1))
			setListener(esp)
			with(binding){
				cardImage.
				cardDenominacion.text = esp.denominacion
				cardPrecio.text = esp.precio.toString() + "€/noche"
				cardLocalidad.text = esp.localidad

			}
//			binding.cardDenominacion.text = esp.denominacion
//			binding.cardPrecio.text = esp.precio.toString() + "€/noche"
//			binding.cardLocalidad.text = esp.localidad
		}
	}

	override fun getItemCount(): Int = alojamientos.size

	fun add(alojamiento: Alojamientos) {
		alojamientos.add(alojamiento)
		notifyDataSetChanged()
	}

	fun setAlojamientos(alojamientos: MutableList<Alojamientos>) {
		this.alojamientos = alojamientos
		notifyDataSetChanged()
	}

	fun update(alojamiento: Alojamientos) {

		val index = alojamientos.indexOf(alojamiento)
		if (index != -1) {
			alojamientos[index] = alojamiento
			notifyItemChanged(index)
		}
	}

//	inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//		var binding = AlojamientoItemBinding.bind(view)
//		fun setListener(esp: Alojamientos, posicion: Int) {
//			binding.root.setOnLongClickListener {
//				listener.onLongClickListener(esp, posicion)
//				true
//			}
//		}
//	}
}