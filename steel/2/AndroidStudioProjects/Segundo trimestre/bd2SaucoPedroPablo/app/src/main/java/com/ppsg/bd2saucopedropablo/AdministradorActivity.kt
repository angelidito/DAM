package com.ppsg.bd2saucopedropablo

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ppsg.bd2saucopedropablo.databinding.ActivityAdministradorBinding
import com.ppsg.bd2saucopedropablo.databinding.ActivityCasosBinding

class AdministradorActivity : AppCompatActivity(), EventosListener {

    private lateinit var binding: ActivityAdministradorBinding
    private lateinit var adaptador: AdaptadorBufete
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var db: BufeteDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdministradorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = BufeteDAO(this)
        crearRecycler()
        mostrarTodosCasos()
    }

    private fun crearRecycler() {
        adaptador = AdaptadorBufete(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 1)
        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun mostrarTodosCasos() {
        val listaCasos = db.getAllCasos()
        for (i in 0 until listaCasos.size) {
            adaptador.add(listaCasos[i])
        }
    }

    override fun mostrarDetalles(casos: Casos) {
        intent = Intent(this, InformacionCasoActivity::class.java)
        intent.putExtra("Casos", casos)
        startActivity(intent)
    }
}