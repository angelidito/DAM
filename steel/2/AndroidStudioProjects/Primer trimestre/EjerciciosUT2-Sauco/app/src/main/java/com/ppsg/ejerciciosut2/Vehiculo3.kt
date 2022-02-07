package com.ppsg.ejerciciosut2

open class Vehiculo3 (modelo:String, color: String, marca:String){
    var modelo:String = ""
        get() = "Modelo: $field"
        set(value){
            field=if (value.equals("")) "Empty" else value
        }

    var color:String = ""
        get() = "Color: $field"
        set(value){
            field=if (value.equals("")) "Empty" else value
        }

    var marca:String = ""
        get() = "Marca: $field"
        set(value){
            field=if (value.equals("")) "Empty" else value
        }
    init {
        this.modelo = modelo
        this.color = color
        this.marca = marca
    }
    open fun visualizar(){
        println("$marca, $modelo, $color")
    }
}