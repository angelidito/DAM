package com.martinezangel.bd2.activities

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
	private lateinit var usuario: Usuario
	private var isAdmin = false

	companion object {
		const val CASO = "caso"
	}

	val actualizarCasos =
		registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
			configurarRecycler()
		}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityCasosBinding.inflate(layoutInflater)
		setContentView(binding.root)
		database = BufeteDAO(this)

		usuario = intent.getParcelableExtra(LoginActivity.USUARIO_ACTIVO)!!

		checkIsAdmin()
		binding.btnAnadirCaso.isVisible = isAdmin
		configurarRecycler()

		binding.btnAnadirCaso.setOnClickListener {
			intent = Intent(this, AnadirCasoActivity::class.java)
			intent.putExtra(LoginActivity.USUARIO_ACTIVO, usuario)
			actualizarCasos.launch(intent)
		}
	}

	private fun checkIsAdmin() {
		isAdmin = usuario.tipoPerfil.compareTo("S") == 0
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
			if (isAdmin)
				return database.getAllCasos()
			else
				return database.getCasosFrom(usuario)
		}
		override fun onPostExecute(result: MutableList<Caso>) {
			super.onPostExecute(result)
			adaptador.setCasos(result)
		}
	}

	override fun onClickListener(caso: Caso) {
		intent = Intent(this, InfoCasoActivity::class.java)
		intent.putExtra(CASO, caso)
		startActivity(intent)
	}
}