package com.sde.bd1delgadosergio

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Alojamiento(var codigo:Int, var nombre:String, var localidad:String, var precio:Int, var imagen:String, var telefono:Int, var email:String, var detalles:String, var actividades:String, var favorito:Int): Parcelable{
    override fun toString(): String {
        return localidad
    }
}
