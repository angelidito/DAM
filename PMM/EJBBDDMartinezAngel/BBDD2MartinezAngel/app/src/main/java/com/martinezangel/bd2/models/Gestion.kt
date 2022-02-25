package com.martinezangel.bd2.models

data class Gestion(
	val numeroGestion: Int,
	val numeroCaso: Int,
	val fecha: String,
	val descripcion: String,
	var realizado: String
) {
}