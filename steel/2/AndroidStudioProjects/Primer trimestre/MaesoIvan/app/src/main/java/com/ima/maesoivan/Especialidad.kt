package com.ima.maesoivan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Especialidad(val codEsp:Int, val nomEsp:String, val annosMaxEsp:Int):Parcelable{
    fun codigo():String="$codEsp"
    fun nombre():String="$nomEsp"
    fun annos():String="$annosMaxEsp"
}
