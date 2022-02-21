package com.sde.delgadosergio

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Usuario (val codUsuario:Int, val login:String, val password:String, val nombre:String): Parcelable