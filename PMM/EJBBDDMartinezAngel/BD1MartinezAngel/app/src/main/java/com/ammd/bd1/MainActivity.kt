package com.ammd.bd1

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ammd.bd1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Eventoslistener {

    lateinit var binding: ActivityMainBinding
    private lateinit var database: AlojamientosDAO
    private lateinit var adaptador: AlojamientosAdapter
    private lateinit var gridLayout: GridLayoutManager
    private var ciudad = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        database = AlojamientosDAO(this)


        binding.btnBuscar.setOnClickListener { buscar() }

        configurarRecycler()
    }

    private fun configurarRecycler() {
        adaptador = AlojamientosAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 1)

        getAlojamientos()

        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }


    private fun getAlojamientos() {
        var myAsyncTask = MyAsyncTask().execute()
    }

    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<Alojamientos>>() {
        override fun doInBackground(vararg p0: Void?): MutableList<Alojamientos> {
            var tiendas = database.getAlojamientos(ciudad)
            if (tiendas.size == 0) {
                database.addAlojamientosPrueba()
                tiendas = database.getAllAlojamiento()
            }
            return tiendas
        }

        override fun onPostExecute(result: MutableList<Alojamientos>?) {
            super.onPostExecute(result)
            if (result != null) {
                adaptador.setAlojamientos(result)
            }
        }
    }


    private fun buscar() {
        ciudad = binding.tilCiudad.editText?.text.toString()
        configurarRecycler()
    }

    override fun onLongClickListener(alojamiento: Alojamientos, posicion: Int) {
        intent= Intent(this, InfoAlojamientoActivity::class.java)
        intent.putExtra("alojamiento", alojamiento)
        startActivity(intent)

    }

    override fun openAlojamiento(alojamiento: Alojamientos) {
        intent= Intent(this, InfoAlojamientoActivity::class.java)
        intent.putExtra("alojamiento", alojamiento)
        startActivity(intent)
    }

    override fun onFavorito(alojamiento: Alojamientos) {
        if (alojamiento.favorito == 0)
            alojamiento.favorito = 1
        else
            alojamiento.favorito = 0
        database.updateAlojamiento(alojamiento)
        adaptador.update(alojamiento)
    }
}