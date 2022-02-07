package com.ppsg.saucopedropablo

data class Usuario(var dni:String, var  nombre:String, var anno:String, var codigo:String){
    fun personalizado(): String = "$dni $nombre $anno $codigo"
}
