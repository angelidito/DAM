package com.examen.recmartinezangel.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.examen.recmartinezangel.databinding.ActivityFaltasBinding
import com.examen.recmartinezangel.db.ColegioDAO
import com.examen.recmartinezangel.eventlisteners.FaltasListener

class FaltasActivity : AppCompatActivity(), FaltasListener {
	private lateinit var database: ColegioDAO
	lateinit var binding: ActivityFaltasBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityFaltasBinding.inflate(layoutInflater)
		setContentView(binding.root)

		database = ColegioDAO(this)

		onAñadirClickListener()

	}

	override fun onAñadirClickListener() {
		binding.btnAAdir.setOnClickListener {
			tratarDatos()
		}

	}

	private fun tratarDatos() {


		val codigoAlumno = binding.nombreAlumnoTil.editText?.text.toString().trim()
		val fecha = binding.fechaTil.editText?.text.toString().trim()
		val hora = binding.horaTil.editText?.text.toString().trim()
		var codigoProfesor = intent.getStringExtra("codigoProfesor")

		if (codigoAlumno.isBlank() || fecha.isBlank() || hora.isBlank()) {
			Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show()
			return
		}

		val alumno = database.getAlumno(codigoAlumno)
		if (alumno == null) {
			Toast.makeText(this, "El alumno introducido no existe", Toast.LENGTH_LONG).show()
			return
		}

		if (!database.hayRelacionProfesorAlumno(codigoProfesor, codigoAlumno)) {
			Toast.makeText(this, "Usted no da clase a este alumno", Toast.LENGTH_LONG).show()
			return
		}

		val falta = database.comprobarFalta(codigoAlumno, fecha, hora)

		if (falta == null) {
			database.añadirFalta(codigoAlumno, fecha, hora, codigoProfesor)
			Toast.makeText(this, "Falta añadida", Toast.LENGTH_LONG).show()
			finish()
		} else {
			if (codigoProfesor != null) {
				if (falta.codigoProfesor == codigoProfesor.toInt()) {
					Toast.makeText(this, "Usted ya ha añadido esta falta", Toast.LENGTH_LONG)
						.show()
				} else {
					database.modificarObervacion(falta, codigoProfesor)
				}
			} else {
				Toast.makeText(
					this,
					"Esto no deberia llegar a ocurrir, parece que la variable codigoProfesor es nula... Logeese de nuevo.",
					Toast.LENGTH_LONG
				).show()
			}
		}

	}
}