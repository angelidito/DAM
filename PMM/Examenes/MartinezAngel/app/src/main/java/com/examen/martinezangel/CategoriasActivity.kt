package com.examen.martinezangel

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.ammd.martinezangel.CategoriasAdapter
import com.ammd.martinezangel.EventosListener

import com.examen.martinezangel.Categoria
import com.examen.martinezangel.EmpresaDAO
import com.examen.martinezangel.databinding.ActivityCategoriasBinding


class CategoriasActivity : AppCompatActivity(), EventosListener {

	private lateinit var binding: ActivityCategoriasBinding
	private lateinit var database: EmpresaDAO
	private lateinit var adaptador: CategoriasAdapter
	private lateinit var gridLayout: GridLayoutManager

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityCategoriasBinding.inflate(layoutInflater)
		setContentView(binding.root)

		database = EmpresaDAO(this)

		configurarRecycler()
	}

	private fun configurarRecycler() {
		adaptador = CategoriasAdapter(mutableListOf(), this)
		gridLayout = GridLayoutManager(this, 1)

		Thread {
			val categorias = database.getCategorias()

			adaptador.setCategorias(categorias)
		}.start()

		binding.RecyclerView.apply {
			setHasFixedSize(true)
			layoutManager = gridLayout
			adapter = adaptador
		}
	}

	override fun onClickListenerCall(code: Int) {
		TODO("Not yet implemented")
	}

	private inner class getAllCategoriasAsyncTask() :
		AsyncTask<Void, Void, MutableList<Categoria>>() {
		override fun doInBackground(vararg p0: Void?): MutableList<Categoria> {
			return database.getCategorias()
		}

		override fun onPostExecute(result: MutableList<Categoria>?) {
			super.onPostExecute(result)
			if (result != null) {
				adaptador.setCategorias(result)
			}
		}
	}


	// tres puntitos
	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.menu, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.validar -> {
				var intent = Intent(this, LoginActivity::class.java)
				startActivity(intent)
				this.finish()
			}
			R.id.desconectar -> {
				var intent = Intent(this, LoginActivity::class.java)
				startActivity(intent)
				this.finish()
			}
		}
		return super.onOptionsItemSelected(item)
	}
}
