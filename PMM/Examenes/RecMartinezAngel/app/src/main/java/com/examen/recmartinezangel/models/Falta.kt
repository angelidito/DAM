package com.examen.recmartinezangel.models

data class Falta(
	val codigoFalta: Int,
	val codigoAlumno: Int,
	val fecha: String?,
	val hora: Int,
	val codigoProfesor: Int,
	var justificada: Int,
	var observaciones: String?
) {

}
