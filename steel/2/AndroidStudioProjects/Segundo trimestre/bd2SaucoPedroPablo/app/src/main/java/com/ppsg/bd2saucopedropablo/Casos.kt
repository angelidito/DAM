package com.ppsg.bd2saucopedropablo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Casos(
    val numeroCaso: Int, val denominacion: String,
    val fecha: String, val caracteristicas: String, val numAbogado:String
): Parcelable {
    override fun toString(): String {
        return "Bufete(numeroCaso='$numeroCaso', denominacion='$denominacion', fecha='$fecha', caracteristicas='$caracteristicas', numAbogado='$numAbogado')"
    }


}