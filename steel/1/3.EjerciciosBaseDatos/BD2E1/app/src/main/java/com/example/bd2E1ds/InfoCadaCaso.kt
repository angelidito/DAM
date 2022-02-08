package com.example.bd2E1ds

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bd2E1ds.databinding.ActivityInfoCadaCasoBinding

class InfoCadaCaso : AppCompatActivity(), EventosListener2 {
    private lateinit var caso: Caso
    private lateinit var binding:ActivityInfoCadaCasoBinding
    private lateinit var adaptador: GestionAdapter
    private lateinit var gridLayout:GridLayoutManager
    private lateinit var bd: BufeteDAO

    companion object{
        const val NUM_CASO = "numCaso"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInfoCadaCasoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = BufeteDAO(this)
        caso = intent.getParcelableExtra(CasosActivity.CASO)!!

        binding.btnNuevaGestion.setOnClickListener{
            intent = Intent(this, NuevaGestionActivity::class.java)
            intent.putExtra(NUM_CASO, caso.numCaso.toString())
            actualizarGestiones.launch(intent)
        }

        binding.lblNombreCaso.text = caso.denominacion
        binding.numeroCaso.text = caso.numCaso.toString()
        binding.fechaApertura.text = caso.fechaApertura
        binding.caracteristicas.text = caso.caracteristicas

        configurarRecyclerGestiones()
    }

    // La actividad 1 llama a la Actividad 2. Cuando en la 2 se encuentre un 'finish' se vuelve
    // a la Actividad 1 y se ejecuta el siguiente código:
    val actualizarGestiones = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        configurarRecyclerGestiones()
    }

    private fun configurarRecyclerGestiones() {
        adaptador = GestionAdapter(mutableListOf(),this)
        gridLayout = GridLayoutManager(this,1)
        consultaGestionesCaso()
        binding.recyclerGestiones.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun consultaGestionesCaso() {
        val myAsyncTask = MyAsyncTask().execute()
    }

    private inner class MyAsyncTask() : AsyncTask<Void, Void, MutableList<Gestion>>() {
        override fun doInBackground(vararg params: Void?): MutableList<Gestion> {
            return bd.consultaGestionesCaso(caso.numCaso.toString())
        }

        override fun onPostExecute(result: MutableList<Gestion>) {
            super.onPostExecute(result)
            adaptador.setGestion(result)
        }
    }

    override fun onLongClickListener(gestion: Gestion) {
        val gestionRealizada = bd.gestionRealizada (gestion.numGestion)

        if (gestionRealizada == "SI"){
            Toast.makeText(this, "Esta gestión ya se encuentra realizada!", Toast.LENGTH_LONG).show()
        }
        else {
            bd.cambiarEstadoGestion(gestion.numGestion)
            Toast.makeText(this, "Gestión actualizada correctamente!", Toast.LENGTH_LONG).show()
        }
    }
}