package com.example.bd1saucopedropablo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Portal(
    val codAlojamiento: Int, val denominacion: String,
    val localidad: String, val precio: Int, val imagen: String, val telefono: Int,
    val email: String, val detalles: String, val actividades: String, var favorito: Int
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Portal

        if (codAlojamiento != other.codAlojamiento) return false

        return true
    }

    override fun hashCode(): Int {
        return codAlojamiento
    }

    override fun toString(): String {
        return "Portal(localidad='$localidad')"
    }

}
