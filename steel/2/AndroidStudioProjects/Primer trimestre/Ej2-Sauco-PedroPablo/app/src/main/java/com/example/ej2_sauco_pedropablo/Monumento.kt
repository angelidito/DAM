package com.example.ej2_sauco_pedropablo

import android.net.Uri

data class Monumento(
    var imagen: String, var nombre:String, var ubicacion:String, var telefono: Uri,
    var email:String, var descipcion:String){
    fun producto():String="$imagen $nombre $ubicacion $telefono $email $descipcion"
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Monumento

        if (imagen != other.imagen) return false
        if (nombre != other.nombre) return false
        if (ubicacion != other.ubicacion) return false
        if (telefono != other.telefono) return false
        if (email != other.email) return false
        if (descipcion != other.descipcion) return false

        return true
    }

    override fun hashCode(): Int {
        var result = imagen.hashCode()
        result = 31 * result + nombre.hashCode()
        result = 31 * result + ubicacion.hashCode()
        result = 31 * result + telefono.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + descipcion.hashCode()
        return result
    }
}
