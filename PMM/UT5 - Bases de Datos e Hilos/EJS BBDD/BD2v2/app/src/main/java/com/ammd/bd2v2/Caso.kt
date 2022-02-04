package com.ammd.bd2v2

data class Caso(
	var numeroCaso: String,
	var denominacion: String,
	var fechaApertura: String,
	var caracteristicas: String,
	var abogado: String
) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as Caso

		if (numeroCaso != other.numeroCaso) return false

		return true
	}
}