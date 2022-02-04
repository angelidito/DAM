package com.ammd.bd2v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ammd.bd2v2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
	lateinit var binding: ActivityLoginBinding
	private lateinit var database: AbogadosDAO
	private lateinit var adapter: AbogadosAdapter


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)

		// TODO: lanzar hilo pantalla de carga

		database = AbogadosDAO(this)

		configurarRecicler()


	}

	override fun onResume() {
		super.onResume()
		configurarRecicler()
	}

	private fun configurarRecicler() {
		TODO("Not yet implemented")
	}
}