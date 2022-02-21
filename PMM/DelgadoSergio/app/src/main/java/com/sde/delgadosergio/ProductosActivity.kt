package com.sde.delgadosergio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.sde.delgadosergio.databinding.ActivityProductosBinding

class ProductosActivity : AppCompatActivity(), EventosListenerProductos {
    private lateinit var binding: ActivityProductosBinding
    private lateinit var adaptador: ProductoAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var bd: TiendaDAO
    private var codCategoria =0
    private lateinit var codUsuario: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = TiendaDAO(this)

        codCategoria = intent.getIntExtra(ConsultaCategoriasActivity.COD_CATEGORIA, -1)
        codUsuario = intent.getStringExtra(ConsultaCategoriasActivity.COD_USUARIO)!!

        configurarRecyclerProductosCategoria()
    }

    private fun configurarRecyclerProductosCategoria() {
        adaptador = ProductoAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)
        consultaCategorias()
        binding.recyclerProductos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaCategorias() {
        Thread {
            val productos = bd.consultaProductosCategoria(codCategoria)
            adaptador.setProductos(productos)
        }.start()
    }

    companion object{
        const val COD_USUARIO = "usuario"
        const val PRODUCTO = "producto"
    }

    override fun onClickListener(producto: Producto) {
        intent = Intent(this, InfoCadaProductoActivity::class.java)
        intent.putExtra(COD_USUARIO, codUsuario)
        intent.putExtra(PRODUCTO, producto)
        startActivity(intent)
    }
}