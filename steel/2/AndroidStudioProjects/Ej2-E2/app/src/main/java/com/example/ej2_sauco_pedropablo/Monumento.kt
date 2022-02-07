package com.example.ej2_sauco_pedropablo

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Monumento(
    var imagen: String, var nombre:String, var ubicacion:String, var telefono: Uri,
    var email:String, var descipcion:String):Parcelable{
}
