package com.vdv.tiendas

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.mjpg.tiendas.Tienda
import com.mjpg.tiendas.TiendasDAO
import com.vdv.tiendas.databinding.ActivityMainBinding
import com.vdv.tiendas.databinding.FragmentConsultaFragmentsBinding

class ConsultaFragments : Fragment(), EventosListener {
    private lateinit var binding: FragmentConsultaFragmentsBinding
    private lateinit var adaptador: AdaptadorTienda
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var bd: TiendasDAO
    private var actividad:MainActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConsultaFragmentsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurar()
    }

    private fun configurar(){
        actividad = activity as? MainActivity
    }
/*
    private fun configurarRecycler() {
        adaptador= AdaptadorTienda(mutableListOf(),this)
        gridLayout= GridLayoutManager(this,2)
        getAllTiendas()
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }
*/
    private fun getAllTiendas() {
        val myAsyncTask=MyAsyncTask().execute()
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
        bd.deleteTienda(id)
        adaptador.borrar(id)
    }

    private inner class MyAsyncTask(): AsyncTask<Void, Void, MutableList<Tienda>>(){
        override fun doInBackground(vararg params: Void?): MutableList<Tienda> {
            val tiendas=bd.getAllTiendas()
            return tiendas
        }

        override fun onPostExecute(result: MutableList<Tienda>) {
            super.onPostExecute(result)
            adaptador.setTiendas(result)
        }
    }
}