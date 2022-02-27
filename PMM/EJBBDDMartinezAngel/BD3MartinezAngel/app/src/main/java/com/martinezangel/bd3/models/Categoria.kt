package com.martinezangel.bd3.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Categoria(
    val codigoCategoria: Int,
    val denominacion: String
) : Parcelable