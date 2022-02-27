package com.martinezangel.bd3.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Lista(
    val codigoLista: Int,
    val denominacion: String
) : Parcelable {
}