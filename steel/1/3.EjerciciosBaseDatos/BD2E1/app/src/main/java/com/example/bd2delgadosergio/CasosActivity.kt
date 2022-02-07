package com.example.bd2delgadosergio

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bd2delgadosergio.databinding.ActivityCasosBinding

class CasosActivity : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityCasosBinding
    private lateinit var adaptador:CasoAdapter
    private lateinit var gridLayout:GridLayoutManager
    private lateinit var bd:BufeteDAO
    private lateinit var numAbogado:String
    private lateinit var tipoUsu:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCasosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = BufeteDAO(this)
        tipoUsu = intent.getStringExtra(LoginActivity.TIPO_USUARIO).toString()

        numAbogado = intent.getStringExtra(LoginActivity.NUM_ABOGADO).toString()

        if (tipoUsu == "S"){
            configurarRecyclerTodosCasos()
        }
        else {
            configurarRecyclerCasosAbogado()
        }

        if (tipoUsu == "A"){
            binding.btnNuevoCaso.isVisible = false
        }

        binding.btnNuevoCaso.setOnClickListener {
            intent = Intent(this, NuevoCasoActivity::class.java)
            actualizarCasos.launch(intent)
        }
    }

    // La actividad 1 llama a la Actividad 2. Cuando en la 2 se encuentre un 'finish' se vuelve
    // a la Actividad 1 y se ejecuta el siguiente código:
    val actualizarCasos = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        configurarRecyclerTodosCasos()
    }

    private fun configurarRecyclerTodosCasos() {
        adaptador = CasoAdapter(mutableListOf(),this)
        gridLayout = GridLayoutManager(this,1)
        consultaTodosCasos()
        binding.recyclerCasos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaTodosCasos() {
        val myAsyncTask = MyAsyncTask().execute()
    }

    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<Caso>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Caso> {
            return bd.consultaTodosCasos()
        }

        override fun onPostExecute(result: MutableList<Caso>) {
            super.onPostExecute(result)
            adaptador.setCasos(result)
        }
    }

    private fun configurarRecyclerCasosAbogado(){
        adaptador = CasoAdapter(mutableListOf(),this)
        gridLayout = GridLayoutManager(this,1)
        consultaCasosAbogado()
        binding.recyclerCasos.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaCasosAbogado() {
        val myAsyncTask = MyAsyncTask2().execute()
    }

    private inner class MyAsyncTask2() : AsyncTask<Void, Void, MutableList<Caso>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Caso> {
            return bd.consultaCasosAbogado(numAbogado)
        }

        override fun onPostExecute(result: MutableList<Caso>) {
            super.onPostExecute(result)
            adaptador.setCasos(result)
        }
    }

    companion object{
        const val CASO = "caso"
    }

    // Al realizar una pulsación sobre un caso...
    override fun onClickListener(caso: Caso) {
        intent= Intent(this, InfoCadaCaso::class.java)
        intent.putExtra(CASO, caso)
        startActivity(intent)
    }
}