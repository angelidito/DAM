package com.ppsg.fundamentos

open class Persona( nombre:String, apellidos:String) {
    var edad:Int = 0
    init {
        edad=0
    }

    var nombre:String = ""
    get() = "Nombre: $field"
    set(value){
        field=if (value.isEmpty()) "Sin nombre" else value
    }

    var apellidos:String = ""
    get() {
        return  "Apellidos: $field"
    }
    set(value) {
        field=value.uppercase()
    }
    constructor(nombre: String,apellidos: String, edad:Int):this(nombre,apellidos) {
        this.nombre = nombre
        this.edad = edad
        this.apellidos = apellidos
    }
    open fun visualizar(){
        println("$nombre, $apellidos, $edad")
    }
}