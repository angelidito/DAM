package com.ppsg.bd2saucopedropablo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Gestiones(
    val numeroGestion: Int, val numeroCaso: Int,
    val fecha: String, val descripcion: String, val realizado: String
): Parcelable {
    override fun toString(): String {
        return "Bufete(numeroGestion='$numeroGestion', numeroCaso='$numeroCaso', fecha='$fecha', descripcion='$descripcion', realizado='$realizado')"
    }
}