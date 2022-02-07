package com.ppsg.ejerciciosut2

class Motocicleta (nplazas:Int,maletero:Boolean,modelo:String, color:String, marca:String)
    :Vehiculo3(modelo, color, marca) {
    var nplazas:Int = 0
    var maletero:Boolean = false
        /*
        get() = "Maletero: $field"
        set(value){
            field=if (value.equals(true)) "Tiene maletero" else value
        }*/

    init {
        this.nplazas= nplazas
        this.maletero = maletero
        this.color = color
        this.marca = marca
        this.modelo = modelo
    }

}