package com.martinezangel.bd2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.martinezangel.bd2.bd.BufeteDAO
import com.martinezangel.bd2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
	private lateinit var binding: ActivityLoginBinding
	private lateinit var database: BufeteDAO

	companion object {
		const val USUARIO_ACTIVO = "numeroColegiado"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityLoginBinding.inflate(layoutInflater)
		setContentView(binding.root)

		database = BufeteDAO(this)

		binding.btnAcceder.setOnClickListener {
			intentarAcceso()
		}
	}

	private fun intentarAcceso() {
		val login = binding.txtUsuario.text.toString()
		val contrasena = binding.txtContrasena.text.toString()

		if (login.isEmpty() || contrasena.isEmpty()) {
			Toast.makeText(this, "Rellene todos los campos, por favor.", Toast.LENGTH_SHORT).show()
			return
		}

		val usuario = database.logIn(login, contrasena)

		if (usuario == null) {
			Toast.makeText(this, "Claves de acceso incorrectas", Toast.LENGTH_LONG).show()
			return
		}

		intent = Intent(this, CasosActivity::class.java)
		intent.putExtra(USUARIO_ACTIVO, usuario.numeroColegiado)
		startActivity(intent)


	}
}