package com.sde.ejtiendas

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.sde.ejtiendas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: AdaptadorTienda
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var bd: TiendasDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = TiendasDAO(this)

        configurarRecycler()

        binding.btnSave.setOnClickListener{
            grabar()
        }
    }

    private fun grabar() {
        val tienda = Tienda(1,binding.etName.text.toString(),1)
        Thread { // Realiza la tarea en el hilo secundario
            bd.addTienda(tienda)
            runOnUiThread { adaptador.add(tienda) } // Realiza la tarea en el hilo principal
        }.start()
    }

    private fun configurarRecycler() {
        adaptador = AdaptadorTienda(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 2)
        consultaTiendas()
        binding.recyclerView.apply {
            // Todos los elementos con el mismo tamaño
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    // Esto es la consulta a la base de datos
    private fun consultaTiendas() {
        val myAsyncTask=MyAsyncTask().execute()
    }

    // Que hay que hacer al pulsar click sobre un elemento del Recycler
    override fun editar(id: Int) {

    }

    override fun onFavorito(tienda: Tienda) {
        if(tienda.esFavorito==0)
            tienda.esFavorito=1
        else
            tienda.esFavorito=0
        bd.updateTienda(tienda)
        adaptador.update(tienda)
    }

    override fun borrarTienda(id: Int) {
        Thread{
            bd.deleteTienda(id)
            runOnUiThread { adaptador.borrar(id)}
        }
    }

    private inner class MyAsyncTask(): AsyncTask<Void, Void, MutableList<Tienda>>(){
        override fun doInBackground(vararg params: Void?): MutableList<Tienda> {
            val tiendas=bd.getAllTiendas()
            return tiendas
        }
        /*
        AsyncTask
        Hilo Principal (IU)     HiloSecundario                          (progreso)
        onPreExecute            OnDoBackground (entrada)-> publishProgress--> onProgressUpdate pasa al hilo principal informacion de como va el proceso
                                        \_->    onPostExecute despues de la ejecucion, cuando ha acabado, se ejecuta en el principal
                                    (resultado)
         */

        override fun onPostExecute(result: MutableList<Tienda>) {
            super.onPostExecute(result)
            adaptador.setTiendas(result)
        }
    }
}