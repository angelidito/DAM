package com.ppsg.bd2saucopedropablo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ppsg.bd2saucopedropablo.databinding.ActivityCasosBinding

class AbogadosActivity : AppCompatActivity(), EventosListener {

    private lateinit var binding: ActivityCasosBinding
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var adaptador: AdaptadorBufete
    private lateinit var numeroColegiado: String
    private lateinit var db: BufeteDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCasosBinding.inflate(layoutInflater)
        db = BufeteDAO(this)
        adaptador = AdaptadorBufete(mutableListOf(), this)
        //COGEMOS EL DATO QUE LE HEMOS PASADO EN EL LOGIN
        numeroColegiado = intent.getStringExtra("numeroColegiado").toString()
        setContentView(binding.root)

        crearRecycler()
    }

    private fun crearRecycler() {
        adaptador = AdaptadorBufete(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 1)
        getCasos()
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    //BÚSQUEDA POR CÓDIGO ABOGADO
    private fun getCasos() {
        val myAsyncTask = MyAsyncTask().execute()
    }

    //BÚSQUEDA POR CÓDIGO ABOGADO
    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<Casos>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Casos> {
            val casos = db.getNumCaso(numeroColegiado)
            return casos
        }

        override fun onPostExecute(result: MutableList<Casos>) {
            super.onPostExecute(result)
            adaptador.setAlojamientos(result)
        }
    }

    override fun mostrarDetalles(casos: Casos) {
        intent = Intent(this, InformacionCasoActivity::class.java)
        intent.putExtra("Casos", casos)
        startActivity(intent)
    }

}

//    private fun mostrarCasos() {
//        val listaCasos = db.getNumCaso(numeroColegiado)
//        for (i in 0 until listaCasos.size) {
//            adaptador.add(listaCasos[i])
//        }
//    }
//override fun mostrarDetalles(casos: Casos) {
////            intent = Intent(this, InformacionCasoActivity::class.java)
////            intent.putExtra("Casos", casos)
////            startActivity(intent)
//}




