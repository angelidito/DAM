package com.sde.ejerciciosut2delgado

class Vehiculo1() {
    var marca:String = ""
        get() = "$field"
        set(value){
            field = if (value.isEmpty()) "Empty" else value
        }

    var modelo:String = ""
        get() = "$field"
        set(value){
            field = if (value.isEmpty()) "Empty" else value
        }

    var color:String = ""
        get() = "$field"
        set(value){
            field = if (value.isEmpty()) "Empty" else value
        }
}