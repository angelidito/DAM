package com.martinezangel.bd3.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ListaProducto(
    val codigoListaProducto: Int,
    val codigoLista: Int,
    val codigoProducto: Int,
    val cantidad: Int
) : Parcelable {
}