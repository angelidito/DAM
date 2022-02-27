package com.martinezangel.bd3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.martinezangel.bd3.enventlisteners.ListaProductoEventListener
import com.martinezangel.bd3.R
import com.martinezangel.bd3.databinding.ItemProductoListaBinding
import com.martinezangel.bd3.models.ListaProducto

class ListaProductoAdapter(
    private var listasProductos: MutableList<ListaProducto>,
    private var listener: ListaProductoEventListener
) : RecyclerView.Adapter<ListaProductoAdapter.ViewHolder>() {

    private lateinit var nombresProductos: ArrayList<String>

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemProductoListaBinding.bind(view)

        fun setClickListeners(listaProducto: ListaProducto) {
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(listaProducto)
                true
            }
            binding.root.setOnClickListener {
                listener.onClickListener(listaProducto)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_producto_lista, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listaProducto = listasProductos[position]
        with(holder) {
            setClickListeners(listaProducto)
            binding.denominacionProducto.text = nombresProductos[position]
            binding.cantidadProducto.text = "Unidades: ${listaProducto.cantidad}"
        }
    }

    override fun getItemCount(): Int = listasProductos.size

    fun setProductos(listasProductos: MutableList<ListaProducto>) {
        this.listasProductos = listasProductos
        notifyDataSetChanged()
    }
    fun setNombresProductos(nombresProductos: ArrayList<String>) {
        this.nombresProductos = nombresProductos
    }
}