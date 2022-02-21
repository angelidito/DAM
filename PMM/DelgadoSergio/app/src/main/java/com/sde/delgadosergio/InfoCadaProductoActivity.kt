package com.sde.delgadosergio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.snackbar.Snackbar
import com.sde.delgadosergio.databinding.ActivityInfoCadaProductoBinding

class InfoCadaProductoActivity : AppCompatActivity() {
    private lateinit var producto: Producto
    private lateinit var binding:ActivityInfoCadaProductoBinding
    private lateinit var bd: TiendaDAO
    private lateinit var codUsuario: String
    private lateinit var codProducto: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoCadaProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = TiendaDAO(this)

        producto = intent.getParcelableExtra(ProductosActivity.PRODUCTO)!!
        binding.tituloNombreProducto.text = producto.denominacion
        Glide.with(binding.root).load(producto.imagen).centerCrop().diskCacheStrategy(
            DiskCacheStrategy.ALL
        ).into(binding.imgAlojamiento)
        binding.precioProducto.text = producto.pvp.toString() + "€"
        binding.colorProducto.text = producto.color
        binding.tallaProducto.text = producto.talla

        codProducto = producto.codProducto.toString()
        codUsuario = intent.getStringExtra(ProductosActivity.COD_USUARIO)!!

        if (bd.productoEstaEnFavoritos(codUsuario, codProducto)) {
            binding.btnFavorito.setImageResource(R.drawable.ic_favorito)
        }

        binding.btnFavorito.setOnClickListener {
            if (codUsuario != "null"){
                if (bd.productoEstaEnFavoritos(codUsuario, codProducto)) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle(Html.fromHtml("<b>Confirmación<b>"))
                    builder.setIcon(android.R.drawable.stat_notify_error)
                    builder.setMessage("\n¿Desea eliminar este producto?")
                    // Si aceptas el mensaje se elimina el producto
                    builder.setPositiveButton("Aceptar") { _, _ ->
                        bd.eliminarProductoLista(codUsuario, codProducto)

                        Snackbar.make(binding.root, "Eliminado correctamente!", Snackbar.LENGTH_SHORT)
                            .show()
                        binding.btnFavorito.setImageResource(R.drawable.ic_no_favorito)
                    }
                    // Si cancelas el permiso se cierra esa ventana
                    builder.setNegativeButton("Cancelar", null)
                    builder.show()
                }

                if (!bd.productoEstaEnFavoritos(codUsuario, codProducto)) {
                    bd.addProductoFavoritos(codUsuario, codProducto)
                    binding.btnFavorito.setImageResource(R.drawable.ic_favorito)
                }
            }
            else {
                Snackbar.make(binding.root, "Registrese para añadirlo a favoritos!", Snackbar.LENGTH_SHORT)
                    .show()
            }

        }
    }
}