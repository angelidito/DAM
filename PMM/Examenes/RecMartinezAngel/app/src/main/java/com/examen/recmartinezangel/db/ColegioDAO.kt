package com.examen.recmartinezangel.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.examen.recmartinezangel.models.Alumno
import com.examen.recmartinezangel.models.Falta
import com.examen.recmartinezangel.models.Profesor

class ColegioDAO(context: Context) {
	private val database: SQLiteDatabase

	companion object {
		const val DATABASE_NAME = "MartinezAngel"
		const val DATABASE_VERSION = 1
		const val TABLA_ALUMNOS = "ALUMNOS"
		const val TABLA_FALTAS_ALUMNO = "FALTAS_ALUMNO"
		const val TABLA_PROFESOR = "PROFESOR"
		const val TABLA_PROFESOR_ALUMNO = "PROFESOR_ALUMNO"
	}

	init {
		val estructura = ColegioBD(context, DATABASE_NAME, null, DATABASE_VERSION)
		database = estructura.writableDatabase
	}

	fun logIn(login: String, contrasena: String): Profesor? {
		var sql =
			"select * from $TABLA_PROFESOR where login='$login' and contrasena='$contrasena'"
		val cursor: Cursor = database.rawQuery(sql, null)
		if (cursor.moveToFirst()) {
			val profe = Profesor(
				cursor.getInt(cursor.getColumnIndexOrThrow("codigoProfesor")),
				cursor.getString(cursor.getColumnIndexOrThrow("login")),
				cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
			)
			if (
				profe.login.compareTo(login) == 0
				&& cursor.getString(cursor.getColumnIndexOrThrow("contrasena"))
					.compareTo(contrasena) == 0
			) {
				if (!cursor.isClosed) {
					cursor.close()
				}
				return profe
			}
		}
		return null
	}

	fun getAlumno(nombre: String): Alumno? {
		val cursor = database.rawQuery(
			"SELECT * FROM $TABLA_ALUMNOS WHERE nombre = '$nombre'",
			null
		)
		if (cursor.moveToFirst()) {
			return Alumno(
				cursor.getInt(cursor.getColumnIndexOrThrow("codigoAlumno")),
				cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
			)
		}
		return null
	}

	fun hayRelacionProfesorAlumno(codigoProfesor: String?, codigoAlumno: String): Boolean {
		val cursor = database.rawQuery(
			"SELECT * FROM $TABLA_PROFESOR_ALUMNO WHERE codigoAlumno = '$codigoAlumno' AND codigoProfesor = '$codigoProfesor ",
			null
		)
		if (cursor.moveToFirst()) {
			return true
		}
		return false
	}

	fun comprobarFalta(codigoAlumno: String, fecha: String, hora: String): Falta? {
		val cursor = database.rawQuery(
			"SELECT * FROM $TABLA_FALTAS_ALUMNO WHERE codigoAlumno = '$codigoAlumno' AND fecha = '$fecha' AND hora = '$hora",
			null
		)
		if (cursor.moveToFirst()) {
			return Falta(
				cursor.getInt(cursor.getColumnIndexOrThrow("codigoFalta")),
				cursor.getInt(cursor.getColumnIndexOrThrow("codigoAlumno")),
				cursor.getString(cursor.getColumnIndexOrThrow("fecha")),
				cursor.getInt(cursor.getColumnIndexOrThrow("hora")),
				cursor.getInt(cursor.getColumnIndexOrThrow("codigoProfesor")),
				cursor.getInt(cursor.getColumnIndexOrThrow("justificada")),
				cursor.getString(cursor.getColumnIndexOrThrow("observaciones"))
			)
		}
		return null
	}

	fun añadirFalta(codigoAlumno: String, fecha: String, hora: String, codigoProfesor: String?) {
		database.execSQL("INSERT into $TABLA_FALTAS_ALUMNO (codigoAlumno, fecha, hora, codigoProfesor, justificada, observaciones) values ($codigoAlumno, '$fecha', $hora, $codigoProfesor, 0, '' )")
	}

	fun modificarObervacion(falta: Falta, codigoProfesor: String) {
		// QUEDA POR HACER
	}


}