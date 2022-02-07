package com.example.ej2delgadosergio

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Monumento(val imagen:String, val nombre:String, val ubicacion:String, val telefono:String, val email:String, val descripcion:String): Parcelable