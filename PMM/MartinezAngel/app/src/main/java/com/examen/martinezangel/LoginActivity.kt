package com.examen.martinezangel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ammd.martinezangel.CategoriaAdapter
import com.examen.martinezangel.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
	lateinit var binding: ActivityLoginBinding
	private lateinit var database: EmpresaDAO


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)


		database = EmpresaDAO(this)

		binding.btnAcceder.setOnClickListener {
			var acceso = database.logIn(
				binding.loginTil.editText.toString(),
				binding.passwordTil.editText.toString()
			)
		}

	}

	override fun onResume() {
		super.onResume()
	}


}