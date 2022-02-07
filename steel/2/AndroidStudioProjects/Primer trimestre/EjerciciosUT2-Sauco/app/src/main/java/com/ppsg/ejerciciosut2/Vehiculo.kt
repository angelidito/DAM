package com.ppsg.ejerciciosut2

open class Vehiculo {

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
}