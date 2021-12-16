package com.ammd.bd1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ammd.bd1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Eventoslistener {
    lateinit var binding: ActivityMainBinding
    private lateinit var database: AlojamientosDAO


    private lateinit var adaptador: AlojamientosAdapter
    private lateinit var gridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        TODO: lanzar hilo pantalla de carga

        database = AlojamientosDAO(this)

        addAlojamientosPrueba()

        binding.btnBuscar.setOnClickListener { buscar() }
    }

    private fun configurarRecycler() {
        adaptador = AlojamientosAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)

        getAllAlojamientos()

        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun getAllAlojamientos() {


        Thread {
            val alojamientos = database.getAllAlojamiento()
            runOnUiThread {
                adaptador.setTiendas(alojamientos)
            }
        }.start()
    }



    private fun addAlojamientosPrueba() {
        database.addAlojamiento(
            Alojamientos(
                1,
                "Alohamiendos Mori",
                "Burgos",
                54,
                "https://www.tourinews.es/uploads/s1/74/92/70/hotel-juan-carlos-i-en-barcelona-foto-de-wikimedia-commons-cc-by-sa-4-0_4_732x400.jpeg",
                618245190,
                "correo@yopmail.com",
                "detalles",
                "actividades",
                1
            )
        )

        database.addAlojamiento(
            Alojamientos(
                1,
                "Alohamiendos Mori",
                "Burgos",
                54,
                "https://www.tourinews.es/uploads/s1/74/92/70/hotel-juan-carlos-i-en-barcelona-foto-de-wikimedia-commons-cc-by-sa-4-0_4_732x400.jpeg",
                618245190,
                "correo@yopmail.com",
                "detalles",
                "actividades",
                1
            )
        )
    }

    private fun buscar() {
//        TODO("Not yet implemented")
        ;
    }

    override fun onLongClickListener(alojamiento: Alojamientos, posicion: Int) {
//        TODO("Not yet implemented")
    }
}