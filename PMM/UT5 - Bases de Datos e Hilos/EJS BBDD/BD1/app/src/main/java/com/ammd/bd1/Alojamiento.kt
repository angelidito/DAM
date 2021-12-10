package com.ammd.bd1

data class Alojamiento(
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

        other as Alojamiento

        if (codigo_alojamiento != other.codigo_alojamiento) return false

        return true
    }

}
