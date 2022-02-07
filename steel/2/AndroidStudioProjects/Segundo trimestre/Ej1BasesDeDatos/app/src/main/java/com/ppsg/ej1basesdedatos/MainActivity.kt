package com.ppsg.ej1basesdedatos

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ppsg.ej1basesdedatos.databinding.ActivityMainBinding

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
        binding.btnSave.setOnClickListener {
            grabar()
        }
    }

    private fun grabar() {
        val tienda = Tienda(
            1,
            binding.etName.text.toString().trim(), 1
        )
        Thread {
            db.addTienda(tienda)
            runOnUiThread {
                adaptador.add(tienda)
            }
        }.start()

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

    private fun getAllTiendas() {
        val myAsyncTask = MyAsyncTask().execute()

    }

    override fun editar(id: Int) {

    }

    override fun onFavorito(tienda: Tienda) {
        if (tienda.esFavorito == 0) {
            tienda.esFavorito = 1
        } else {
            tienda.esFavorito = 0
        }
        //Esta línea actualiza la base de datos
        db.updateTienda(tienda)
        adaptador.update(tienda)
    }

    override fun borrarTienda(id: Int) {
        db.deleteTienda(id)
        adaptador.borrar(id)
    }

    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<Tienda>>() {

        override fun doInBackground(vararg p0: Void?): MutableList<Tienda> {
            val tiendas = db.getAllTiendas()
            return tiendas
        }

        override fun onPostExecute(result: MutableList<Tienda>) {
            super.onPostExecute(result)
            adaptador.setTiendas(result)
        }
    }
}