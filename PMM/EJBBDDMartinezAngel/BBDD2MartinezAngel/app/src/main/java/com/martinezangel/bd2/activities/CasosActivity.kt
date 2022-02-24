package com.martinezangel.bd2.activities

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.martinezangel.bd2.bd.BufeteDAO
import com.martinezangel.bd2.databinding.ActivityCasosBinding
import com.martinezangel.bd2.eventlisteners.EventosListener
import com.martinezangel.bd2.models.Caso
import com.martinezangel.bd2.models.Usuario

class CasosActivity : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityCasosBinding
    private lateinit var adaptador: CasoAdapter
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var database: BufeteDAO
    private lateinit var numeroColegiado: String
    private lateinit var usuario: Usuario

    private val esAdmin = usuario.tipoPerfil.compareTo("S") == 0

    // La actividad 1 llama a la Actividad 2. Cuando en la 2 se encuentre un 'finish' se vuelve
    // a la Actividad 1 y se ejecuta el siguiente código:
    val actualizarCasos =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            configurarRecycler()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = BufeteDAO(this)
        val tempUser =
            database.getUsario(intent.getStringExtra(LoginActivity.USUARIO_ACTIVO).toString())
        if (tempUser == null) {
            Toast.makeText(this, "Usuario desconocido", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        // else
        binding = ActivityCasosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuario = tempUser
        binding.btnAnadirCaso.isVisible = esAdmin

        configurarRecycler()

        binding.btnAnadirCaso.setOnClickListener {
            intent = Intent(this, AnadirCasoActivity::class.java)
            actualizarCasos.launch(intent)
        }
    }


    private fun configurarRecycler() {
        adaptador = CasoAdapter(mutableListOf(), this)
        gridLayout = GridLayoutManager(this, 1)
        val myAsyncTask = CargarCasosAsyncTask().execute()
        binding.casosRecycler.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }


    private inner class CargarCasosAsyncTask() : AsyncTask<Void, Void, MutableList<Caso>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Caso> {
            if (esAdmin)
                return database.getAllCasos()
            else
                return database.getCasosFrom(usuario)
        }

        override fun onPostExecute(result: MutableList<Caso>) {
            super.onPostExecute(result)
            adaptador.setCasos(result)
        }
    }


    companion object {
        const val NUMERO_CASO = "numeroCaso"
    }

    // Al realizar una pulsación sobre un caso...
    override fun onClickListener(caso: Caso) {
        intent = Intent(this, InfoCasoActivity::class.java)
        intent.putExtra(NUMERO_CASO, caso.numeroCaso)
        startActivity(intent)
    }
}