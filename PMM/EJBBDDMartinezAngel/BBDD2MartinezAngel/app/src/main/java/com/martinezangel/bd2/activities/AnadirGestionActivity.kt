package com.martinezangel.bd2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.martinezangel.bd2.bd.BufeteDAO
import com.martinezangel.bd2.databinding.ActivityAnadirGestionBinding
import com.martinezangel.bd2.databinding.ActivityInfoCasoBinding
import com.martinezangel.bd2.models.Caso
import com.martinezangel.bd2.models.Gestion
import java.text.SimpleDateFormat
import java.util.*

class AnadirGestionActivity : AppCompatActivity() {
	private lateinit var binding: ActivityAnadirGestionBinding
	private lateinit var database: BufeteDAO

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityAnadirGestionBinding.inflate(layoutInflater)
		setContentView(binding.root)

		database = BufeteDAO(this)
		val caso = intent.getParcelableExtra<Caso>(InfoCasoActivity.CASO) ?: return

		binding.btnAceptar.setOnClickListener {
			val descripcion = binding.tilDescripcionGestion.editText?.text.toString()

			if (descripcion.isEmpty()) {
				Toast.makeText(this, "Escriba una descripción, por favor.", Toast.LENGTH_LONG).show()
				return@setOnClickListener
			}

			val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
			val fecha: String = dateFormat.format(Date())

			database.addGestion(caso.numeroCaso, fecha, descripcion)
			Toast.makeText(this, "Gestión añadida.", Toast.LENGTH_SHORT).show()
			finish()
		}


	}
}