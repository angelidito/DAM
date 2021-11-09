package com.ammd.intents

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Usuario(
    var nombre: String?,
    var apellidos: String?
) : Parcelable {

}