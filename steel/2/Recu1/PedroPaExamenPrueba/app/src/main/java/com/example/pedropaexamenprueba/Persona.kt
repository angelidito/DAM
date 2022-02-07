package com.example.pedropaexamenprueba

data class Persona(val dni:String,val nombreApellido:String,val anno:Int, val codEspecialidad:Int){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Persona

        if (dni != other.dni) return false

        return true
    }

    override fun hashCode(): Int {
        return dni.hashCode()
    }
}
