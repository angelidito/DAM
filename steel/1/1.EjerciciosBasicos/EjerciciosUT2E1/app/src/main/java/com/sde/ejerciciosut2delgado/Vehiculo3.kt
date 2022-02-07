package com.sde.ejerciciosut2delgado

open class Vehiculo3(marca:String, modelo:String, color:String) {
    // El open está puesto para poder hacer la herencia
    var marca:String = marca
        get() = "$field"
        set(value){
            field = if (value.isEmpty()) "Empty" else value
        }

    var modelo:String = modelo
        get() = "$field"
        set(value){
            field = if (value.isEmpty()) "Empty" else value
        }

    var color:String = color
        get() = "$field"
        set(value){
            field = if (value.isEmpty()) "Empty" else value
        }

    init{
        this.marca = marca
        this.modelo = modelo
        this.color = color
    }

    open fun visualizar(){
        println("$marca, $modelo, $color")
    }
}