package com.example.bd2delgadosergio

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Caso (val numCaso:Int, val denominacion:String, val fechaApertura:String, val caracteristicas:String, val numAbogado:Int): Parcelable