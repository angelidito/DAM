package com.example.bd1saucopedropablo

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bd1saucopedropablo.databinding.ActivityBusquedaHotelBinding
import com.google.android.material.snackbar.Snackbar


class BusquedaHotel : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityBusquedaHotelBinding
    private lateinit var adaptador: AdaptadorPortal
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var db: PortalDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busqueda_hotel)
        binding = ActivityBusquedaHotelBinding.inflate(layoutInflater)
        db = PortalDAO(this)
        adaptador = AdaptadorPortal(mutableListOf(), this)
        setContentView(binding.root)
        binding.buscar.setOnClickListener {
            if (binding.txtBuscar.text?.isNotEmpty() == true) {
                //BÚSQUEDA POR LOCALIDAD
                gridLayout = GridLayoutManager(this, 1)
                getAlojamiento()
                binding.recyclerview.apply {
                    setHasFixedSize(true)
                    layoutManager = gridLayout
                    adapter = adaptador
                }
            } else {
                configurarRecycler()
            }
        }
    }

    //BÚSQUEDA POR LOCALIDAD
    private fun getAlojamiento() {
        val myAsyncTask = MyAsyncTask2().execute()
    }

    //BÚSQUEDA POR LOCALIDAD
    private inner class MyAsyncTask2() : AsyncTask<Void, Void, MutableList<Portal>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Portal> {
            val alojamientos = db.getLocalidad(binding.txtBuscar.text.toString())
            return alojamientos
        }

        override fun onPostExecute(result: MutableList<Portal>) {
            super.onPostExecute(result)
            adaptador.setAlojamientos(result)
        }
    }

    private fun configurarRecycler() {
        adaptador = AdaptadorPortal(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 1)
        getAllPortal()
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun getAllPortal() {
        val myAsyncTask = MyAsyncTask().execute()
    }


    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<Portal>>() {
        override fun doInBackground(vararg p0: Void?): MutableList<Portal> {
            val portales = db.getAllAlojamientos()
            return portales
        }

        override fun onPostExecute(result: MutableList<Portal>) {
            super.onPostExecute(result)
            adaptador.setAlojamientos(result)
        }
    }


    override fun mostrarDetalles(portal: Portal) {
        intent = Intent(this, InformacionCadaPortal::class.java)
        intent.putExtra("Portal", portal)
        startActivity(intent)
    }
    //AGREGAR UN HOTEL A FAVORITO
    override fun onFavorito(portal: Portal) {
        if (portal.favorito == 0) {
            portal.favorito = 1
        } else {
            portal.favorito = 0
        }
        db.updateAlojamiento(portal)
        adaptador.update(portal)
    }
}