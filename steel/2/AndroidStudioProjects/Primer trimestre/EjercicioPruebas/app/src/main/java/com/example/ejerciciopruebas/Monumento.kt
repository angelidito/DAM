package com.example.ejerciciopruebas

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Monumento(var codigo: Int,
    var nombre:String,var imagen: String, var ubicacion:String, var telefono: String,
    var email:String, var descipcion:String): Parcelable {
}