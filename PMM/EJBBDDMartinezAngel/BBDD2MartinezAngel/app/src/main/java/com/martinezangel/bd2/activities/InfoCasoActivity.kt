package com.martinezangel.bd2.activities

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.martinezangel.bd2.bd.BufeteDAO
import com.martinezangel.bd2.databinding.ActivityInfoCasoBinding
import com.martinezangel.bd2.eventlisteners.InfoCasoEventListener
import com.martinezangel.bd2.models.*

class InfoCasoActivity : AppCompatActivity(), InfoCasoEventListener {
	private lateinit var caso: Caso
	private lateinit var binding: ActivityInfoCasoBinding
	private lateinit var adaptader: GestionAdapter
	private lateinit var gridLayout: GridLayoutManager
	private lateinit var database: BufeteDAO

	companion object {
		const val CASO = "caso"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityInfoCasoBinding.inflate(layoutInflater)
		setContentView(binding.root)
		database = BufeteDAO(this)
		caso = intent.getParcelableExtra(CasosActivity.CASO)!!

		setData()
		setOnClickAddButton()
		configurarRecyclerGestiones()
	}

	private fun setData() {
		binding.lblNombreCaso.text = caso.denominacion
		binding.numeroCaso.text = caso.numeroCaso
		binding.fechaCaso.text = caso.fechaApertura
		binding.caracteristicasCaso.text = caso.caracteristicas
	}

	private fun setOnClickAddButton() {
		binding.btnAnadirGestion.setOnClickListener {
			intent = Intent(this, AnadirGestionActivity::class.java)
			intent.putExtra(CASO, caso)
			actualizarGestiones.launch(intent)
		}
	}

	val actualizarGestiones =
		registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
			configurarRecyclerGestiones()
		}


	private fun configurarRecyclerGestiones() {
		adaptader = GestionAdapter(mutableListOf(), this)
		gridLayout = GridLayoutManager(this, 1)

		val myAsyncTask = GetGestionesAsyncTask().execute()

		binding.RecyclerViewGestiones.apply {
			setHasFixedSize(true)
			layoutManager = gridLayout
			adapter = adaptader
		}
	}

	private inner class GetGestionesAsyncTask() : AsyncTask<Void, Void, MutableList<Gestion>>() {
		override fun doInBackground(vararg params: Void?): MutableList<Gestion> {
			return database.getGestionesFrom(caso)
		}

		override fun onPostExecute(result: MutableList<Gestion>) {
			super.onPostExecute(result)
			adaptader.setGestion(result)
		}
	}

	override fun onLongClickListener(gestion: Gestion) {
		database.realizarGestion(gestion)
	}
}