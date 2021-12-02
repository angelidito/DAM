package com.ammd.tiendasbuenas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ammd.tiendasbuenas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), EventosListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: AdaptadorTienda
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var db: TiendaDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TiendaDAO(this)

        configurarRecycler()

        binding.btnSave.setOnClickListener { grabar() }


    }

    private fun configurarRecycler() {
        adaptador = AdaptadorTienda(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)

        getAllTiendas()

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaTiendas() {
        TODO()
    }


    private fun grabar() {
        val tienda = Tienda(1, binding.etName.text.toString())
        db.addTienda(tienda)
        adaptador.add(tienda)

    }

    private fun getAllTiendas() {
        val tiendas = db.getAllTiendas()
        adaptador.setTiendas(tiendas)
    }

    override fun editar(id: Int) {
        TODO()
    }
}