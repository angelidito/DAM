package com.sde.delgadosergio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.sde.delgadosergio.databinding.ActivityConsultaCategoriasBinding

class ConsultaCategoriasActivity : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityConsultaCategoriasBinding
    private lateinit var adaptador: CategoriaAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var bd: TiendaDAO
    private lateinit var codUsuario: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConsultaCategoriasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = TiendaDAO(this)
        codUsuario = intent.getStringExtra(LoginActivity.COD_USUARIO).toString()

        configurarRecyclerCategorias()
    }

    private fun configurarRecyclerCategorias() {
        adaptador = CategoriaAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 1)
        consultaCategorias()
        binding.recyclerCategorias.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaCategorias() {
        Thread {
            val categorias = bd.consultaCategorias()
            adaptador.setCategorias(categorias)
        }.start()
    }

    companion object{
        const val COD_USUARIO = "codUsuario"
        const val COD_CATEGORIA = "codCategoria"
    }

    override fun onClickListener(categoria: Categoria) {
        intent= Intent(this, ProductosActivity::class.java)
        intent.putExtra(COD_USUARIO, codUsuario)
        intent.putExtra(COD_CATEGORIA, categoria.codCategoria)
        startActivity(intent)
    }
}