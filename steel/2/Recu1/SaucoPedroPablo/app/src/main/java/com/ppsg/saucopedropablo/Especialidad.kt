package com.ppsg.saucopedropablo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Especialidad(var codigo: Int, var nombre: String, var annos: Int) : Parcelable {
    fun personalizado(): String = "$codigo $nombre $annos"
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Especialidad

        if (codigo != other.codigo) return false
        if (nombre != other.nombre) return false
        if (annos != other.annos) return false

        return true
    }

    override fun hashCode(): Int {
        var result = codigo
        result = 31 * result + nombre.hashCode()
        result = 31 * result + annos
        return result
    }

}
