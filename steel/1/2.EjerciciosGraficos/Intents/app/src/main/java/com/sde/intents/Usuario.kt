package com.sde.intents

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(var nombre:String?, var apellidos:String?): Parcelable {

}
