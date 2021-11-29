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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        confufurarRecycler()

    }

    private fun confufurarRecycler() {
        adaptador =
            AdaptadorTienda(
                mutableListOf(
                    Tienda(1, "Uno", false),
                    Tienda(1, "Dos", false)
                ),
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