package com.martinezangel.bd3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.martinezangel.bd3.R
import com.martinezangel.bd3.databinding.ItemProductoBinding
import com.martinezangel.bd3.enventlisteners.ProductoEventListener
import com.martinezangel.bd3.models.Producto

class ProductoAdapter(
    private var productos: MutableList<Producto>,
    private var listener: ProductoEventListener
) : RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemProductoBinding.bind(view)
        fun setClickListeners(producto: Producto) {
            binding.root.setOnLongClickListener {
                listener.onLongClickListener(producto)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = productos[position]
        with(holder) {
            setClickListeners(producto)

            binding.denominacionProducto.text = producto.denominacion
            Glide.with(binding.root)
                .load(producto.imagen)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imgProducto)
        }
    }

    override fun getItemCount(): Int = productos.size

    fun setProductos(productos: MutableList<Producto>) {
        this.productos = productos
        notifyDataSetChanged()
    }
}