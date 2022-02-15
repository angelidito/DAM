package com.examen.martinezangel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.examen.martinezangel.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
	lateinit var binding: ActivityLoginBinding
	private lateinit var database: EmpresaDAO


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)


		database = EmpresaDAO(this)

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