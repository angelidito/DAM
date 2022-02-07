package com.example.ejpracticaparaexamen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Monumento(val codigo:String, val imagen:String, val nombre:String, val ubicacion:String, val telefono:String, val email:String, val descripcion:String): Parcelable