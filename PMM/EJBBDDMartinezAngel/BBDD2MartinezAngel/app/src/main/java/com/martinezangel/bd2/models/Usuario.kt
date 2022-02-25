package com.martinezangel.bd2.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Usuario(
	val numeroColegiado: String,
	val nombre: String,
	val login: String,
	val tipoPerfil: String
) : Parcelable {
}