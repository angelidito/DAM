package com.sde.delgadosergio

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Producto (val codProducto:Int, val codCategoria:Int, val denominacion:String, val pvp:Int, val imagen:String, val color:String, val talla:String): Parcelable {
}