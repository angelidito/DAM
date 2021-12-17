package com.ammd.tiendasbuenas

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ammd.tiendasbuenas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), EventosListener {

    lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: AdaptadorTienda
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var database: TiendaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = TiendaDAO(this)

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
        Thread {
            database.addTienda(tienda)
            runOnUiThread {
                adaptador.add(tienda)
            }
        }.start()

    }

    private fun getAllTiendas() {
//        val tiendas = database.getAllTiendas()
//        adaptador.setTiendas(tiendas)

        var myAsyncTask = MyAsyncTask().execute()
    }

    override fun editar(id: Int) {
        TODO()
    }

    override fun onFavorito(tienda: Tienda) {
        if (tienda.esFavorito == 0)
            tienda.esFavorito = 1
        else
            tienda.esFavorito = 0
        database.updateTienda(tienda)
        adaptador.update(tienda)
    }

    override fun borrarTienda(id: Int) {
        Thread {
            database.deleteTienda(id)
            runOnUiThread {
                adaptador.borrar(id)
            }
        }
    }

    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<Tienda>>() {
        override fun doInBackground(vararg p0: Void?): MutableList<Tienda> {
            val tiendas = database.getAllTiendas()
            return tiendas
        }

        override fun onPostExecute(result: MutableList<Tienda>?) {
            super.onPostExecute(result)
            if (result != null) {
                adaptador.setTiendas(result)
            }
        }
    }
}