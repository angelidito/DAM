package com.vdv.tiendas

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.vdv.tiendas.databinding.ActivityMainBinding
import com.vdv.tiendas.databinding.FragmentConsultaBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ConsultaFragment : Fragment(),EventosListener {
    /*override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding= .inflate(layoutInflater)
            setContentView(binding.root)
            bd=TiendasDAO(this)
            configurarRecycler()
            binding.btnSave.setOnClickListener{
                grabar()
            }
        }*/
    private lateinit var tiendas:MutableList<Tienda>
    private lateinit var binding: FragmentConsultaBinding
    private lateinit var adaptador:AdaptadorTienda
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var bd:TiendasDAO
    private  var actividad:MainActivity?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentConsultaBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurar()
    }

    private fun configurar() {
        actividad=activity as? MainActivity
    }

   /* private fun configurarRecycler() {
        adaptador= AdaptadorTienda(mutableListOf(),this)
        gridLayout= GridLayoutManager(this,2)
        getAllTiendas()
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=gridLayout
            adapter=adaptador
        }
    }*/

    private fun getAllTiendas() {
       // val myAsyncTask=MyAsyncTask().execute()
        consultaCorrutinas()
    }

    private fun consultaCorrutinas() {
        GlobalScope.launch(Dispatchers.IO){
            tiendas=bd.getAllTiendas()
            launch(Dispatchers.Main){
                adaptador.setTiendas(tiendas)
            }
        }
    }

    override fun editar(id: Long) {

    }

    override fun onFavorito(tienda: Tienda) {
        if(tienda.esFavorito==0)
            tienda.esFavorito=1
        else
            tienda.esFavorito=0
        bd.updateTienda(tienda)
        adaptador.update(tienda)
    }

    override fun borrarTienda(id: Long) {
        GlobalScope.launch (Dispatchers.IO){
            bd.deleteTienda(id)
            launch(Dispatchers.Main) {
                adaptador.borrar(id)
            }
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
/*
Libreria ROOM - GOOGLE
Estructura Tablas
 ENTIDADES              DAO        DATABASE
    codigo                          Estructura BD
    denominacion
    favorito
 */