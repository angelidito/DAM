package com.ppsg.ejerciciosut2

class Coche (npuertas:Int,nplazas:Int,modelo:String, color:String, marca:String)
    :Vehiculo3(modelo, color, marca) {
    var npuertas:Int = 0
    var nplazas:Int = 0

    init {
        this.nplazas= nplazas
        this.npuertas = npuertas
        this.color = color
        this.marca = marca
        this.modelo = modelo
    }
}