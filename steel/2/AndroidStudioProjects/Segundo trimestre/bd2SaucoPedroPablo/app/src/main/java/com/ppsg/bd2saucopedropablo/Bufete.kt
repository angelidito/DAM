package com.ppsg.bd2saucopedropablo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Bufete(
    val numeroColegiado: String, val nombre: String,
    val login: String, val contrasena: String, val tipo: String
): Parcelable {
    override fun toString(): String {
        return "Bufete(numeroColegiado='$numeroColegiado', nombre='$nombre', login='$login', contrasena='$contrasena', tipo='$tipo')"
    }
}