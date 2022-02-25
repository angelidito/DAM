package com.martinezangel.bd2.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Caso(
    val numeroCaso: String,
    val denominacion: String,
    val fechaApertura: String,
    val caracteristicas: String,
    val abogado: String
) : Parcelable {
}