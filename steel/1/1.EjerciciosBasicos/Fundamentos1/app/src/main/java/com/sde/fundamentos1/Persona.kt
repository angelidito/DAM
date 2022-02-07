package com.sde.fundamentos1

open class Persona(nombre:String, apellidos:String) {
    var nombre:String = ""
        get() = "$field" //Como el get está debajo del nombre, se refiere al nombre
        set(value){
            field = if (value.isEmpty()) "Sin nombre" else value // Si el campo está vacío, escribe "Sin nombre", sino escribe el valor del nombre
        }



    var apellidos:String = ""
        get() { // El get está debajo del apellido por lo que se refiere al apellido
            return "$field"
        }
    set(value){
        field = value.uppercase()
    }

    var edad:Int

    init{                           // Este es el constructor principal
        this.nombre = nombre
        this.apellidos = apellidos
        edad=0
    }

    constructor(nombre:String, apellidos: String, edad:Int):this(nombre, apellidos){    // Este es el constructor secundario
        this.edad = edad
        this.nombre = nombre
        this.apellidos = apellidos
    }

    open fun visualizar(){
        println("$nombre $apellidos, $edad")
    }
}