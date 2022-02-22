package com.examen.recmartinezangel.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.examen.recmartinezangel.databinding.ActivityLoginBinding
import com.examen.recmartinezangel.db.ColegioDAO

class LoginActivity : AppCompatActivity() {
	private lateinit var database: ColegioDAO
	lateinit var binding: ActivityLoginBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)

		var optionsActivity = Intent(this, OptionsActivity::class.java)

		database = ColegioDAO(this)



		binding.btnAcceder.setOnClickListener {
			val usuario = binding.loginTil.editText?.text.toString().trim()
			val contrasena = binding.passwordTil.editText?.text.toString().trim()

			var profesor = database.logIn(usuario, contrasena)

//			println("Acceso: $acceso; usuario: $usuario; contraseña: contrasena")

			if (profesor != null)
			{
				intent.putExtra("codigoProfesor", profesor.codigo)
				startActivity(optionsActivity)

			}
		}

	}

	override fun onResume() {
		super.onResume()
	}
}