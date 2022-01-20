package com.ammd.bd2

data class Alojamientos(
    var codigo_alojamiento: Int,
    var denominacion: String,
    var localidad: String,
    var precio: Int,
    var imagen_alojamiento: String,
    var telefono: Int,
    var email: String,
    var detalles: String,
    var actividades: String,
    var favorito: Int
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Alojamientos

        if (codigo_alojamiento != other.codigo_alojamiento) return false

        return true
    }

}
