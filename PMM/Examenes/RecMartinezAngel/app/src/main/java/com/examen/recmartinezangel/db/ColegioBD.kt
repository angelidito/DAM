package com.examen.recmartinezangel.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ColegioBD(
	context: Context,
	name: String,
	factory: SQLiteDatabase.CursorFactory?,
	version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

	override fun onCreate(db: SQLiteDatabase?) {
		val crearTablaCategorias =
			"CREATE TABLE ${ColegioDAO.TABLA_ALUMNOS}" +
					"(" +
					"codigoAlumno INTEGER PRIMARY KEY AUTOINCREMENT, " +
					"nombre varchar(10)" +
					")"
		db!!.execSQL(crearTablaCategorias)

		val crearTablaProductos =
			"CREATE TABLE ${ColegioDAO.TABLA_FALTAS_ALUMNO}" +
					"(" +
					"codigoFalta INTEGER PRIMARY KEY AUTOINCREMENT, " +
					"codigoAlumno INTEGER, " +
					"fecha TEXT, " +
					"hora INTEGER NOT NULL, " +
					"codigoProfesor INTEGER NOT NULL, " +
					"justificada BOOLEAN," +
					"observaciones varchar(30), " +
					"UNIQUE(codigoAlumno,fecha, hora)" +
					")"
		db.execSQL(crearTablaProductos)

		val crearTablaUsuarios =
			"CREATE TABLE ${ColegioDAO.TABLA_PROFESOR}" +
					"(" +
					"codigoProfesor INTEGER PRIMARY KEY AUTOINCREMENT, " +
					"login varchar(10) UNIQUE, " +
					"contrasena varchar(10), " +
					"nombre varchar(20)" +
					")"
		db.execSQL(crearTablaUsuarios)

		val crearTablaListaDeseos =
			"CREATE TABLE ${ColegioDAO.TABLA_PROFESOR_ALUMNO}" +
					"(" +
					"codigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
					"codigoAlumno INTEGER," +
					"codigoProfesor INTEGER, UNIQUE(codigoAlumno, codigoProfesor) " +
					")"
		db.execSQL(crearTablaListaDeseos)

		Thread {
			db.execSQL("INSERT into ${ColegioDAO.TABLA_ALUMNOS} (nombre) values ('Mori')")
			db.execSQL("INSERT into ${ColegioDAO.TABLA_ALUMNOS} (nombre) values ('Juan')")
			db.execSQL("INSERT into ${ColegioDAO.TABLA_ALUMNOS} (nombre) values ('Maria')")

			db.execSQL("INSERT into ${ColegioDAO.TABLA_PROFESOR} (login, contrasena, nombre ) values ('1', '1', 'MJ')")
			db.execSQL("INSERT into ${ColegioDAO.TABLA_PROFESOR} (login, contrasena, nombre ) values ('2', '2', 'Guille')")

			db.execSQL("INSERT into ${ColegioDAO.TABLA_FALTAS_ALUMNO} (codigoAlumno, fecha, hora, codigoProfesor, justificada, observaciones) values (1, 'lunes', 1, 1, 1, 'Todo Ok' )")
			db.execSQL("INSERT into ${ColegioDAO.TABLA_FALTAS_ALUMNO} (codigoAlumno, fecha, hora, codigoProfesor, justificada, observaciones) values (2, 'lunes', 3, 1, 0, 'no vino' )")

			db.execSQL("INSERT into ${ColegioDAO.TABLA_PROFESOR_ALUMNO} (codigoAlumno, codigoProfesor) values (1, 1)")
			db.execSQL("INSERT into ${ColegioDAO.TABLA_PROFESOR_ALUMNO} (codigoAlumno, codigoProfesor) values (2, 1)")
			db.execSQL("INSERT into ${ColegioDAO.TABLA_PROFESOR_ALUMNO} (codigoAlumno, codigoProfesor) values (2, 2)")
			db.execSQL("INSERT into ${ColegioDAO.TABLA_PROFESOR_ALUMNO} (codigoAlumno, codigoProfesor) values (1, 2)")
			db.execSQL("INSERT into ${ColegioDAO.TABLA_PROFESOR_ALUMNO} (codigoAlumno, codigoProfesor) values (3, 2)")


		}.start()
	}

	override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
		TODO("Not yet implemented")
	}
}