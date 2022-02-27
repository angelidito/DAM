package com.martinezangel.bd3.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Producto(
    val codigoProducto: Int,
    val denominacion: String,
    val codigoCategoria: Int,
    val imagen: String
) : Parcelable {
}