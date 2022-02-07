package com.example.pedropaexamenprueba

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Especialidad(val codigo:Int, val nombre:String,val annos:Int) : Parcelable {
    fun codigo():String="$codigo"
    fun nombre():String="$nombre"
    fun annos():String="$annos"
}
