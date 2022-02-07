package com.sde.delgadosergio

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Especialidad(val codigo:Int, val nombre:String, val annosMinimos:Int): Parcelable