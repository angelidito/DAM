package com.sde.delgadosergio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sde.delgadosergio.databinding.ItemProductoBinding

class ProductoAdapter (private var productos: MutableList<Producto>, private var listener: EventosListenerProductos)
    : RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    private lateinit var contexto: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemProductoBinding.bind(view)
        fun setListener(productos: Producto) {
            binding.root.setOnClickListener {
                listener.onClickListener(productos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_producto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = productos.get(position)
        with(holder) {
            setListener(producto)
            binding.nombreProducto.text = producto.denominacion

            Glide.with(binding.root).load(producto.imagen).centerCrop().diskCacheStrategy(
                DiskCacheStrategy.ALL).into(binding.imgProducto)
        }
    }

    override fun getItemCount(): Int = productos.size

    fun setProductos(productos: MutableList<Producto>) {
        this.productos = productos
        notifyDataSetChanged()
    }
}