package com.ammd.tiendasbuenas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.ammd.tiendasbuenas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), EventosListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: AdaptadorTienda
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var bd: TiendaDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = TiendaDAO(this)

        confufurarRecycler()

        binding.btnSave.setOnClickListener { grabar() }

    }

    private fun grabar() {
        val tienda = Tienda(1, binding.etName.text.toString())
        bd.addTienda(tienda)


    }

    private fun confufurarRecycler() {
        adaptador =
            AdaptadorTienda(
                mutableListOf(),
                this
            )
        gridLayout = GridLayoutManager(this, 2)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaTiendas() {
        TODO()
    }

    override fun editar(id: Long) {
        TODO()
    }
}