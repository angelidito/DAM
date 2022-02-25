package com.martinezangel.bd2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.martinezangel.bd2.bd.BufeteDAO
import com.martinezangel.bd2.databinding.ActivityAnadirCasoBinding
import com.martinezangel.bd2.models.Caso
import java.text.SimpleDateFormat
import java.util.*

class AnadirCasoActivity : AppCompatActivity() {
	private lateinit var binding: ActivityAnadirCasoBinding
	private lateinit var database: BufeteDAO

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityAnadirCasoBinding.inflate(layoutInflater)
		setContentView(binding.root)

		database = BufeteDAO(this)

		binding.btnAceptar.setOnClickListener {
			if (setOnClickAceptar()) return@setOnClickListener
			finish()
		}
	}

	private fun setOnClickAceptar(): Boolean {
		val denominacion = binding.tilDenominacionCaso.editText?.text.toString()
		val abogado = binding.tilAbogado.editText?.text.toString()
		val caracteristicas = binding.tilCaracteristicas.editText?.text.toString()

		if (denominacion.isNullOrBlank() || abogado.isNullOrBlank() || caracteristicas.isNullOrBlank()) {
			Toast.makeText(this, "Rellene todos los campos.", Toast.LENGTH_SHORT).show()
			return true
		}
		val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
		val fecha: String = dateFormat.format(Date())
		val caso = Caso("", denominacion, fecha, caracteristicas, abogado)

		database.addCaso(caso)
		Toast.makeText(this, "Caso añadido.", Toast.LENGTH_LONG).show()

		return false
	}
}