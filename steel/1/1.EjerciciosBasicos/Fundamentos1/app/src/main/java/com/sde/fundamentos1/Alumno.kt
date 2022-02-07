package com.sde.fundamentos1

import com.sde.fundamentos1.Persona as Persona1

class Alumno(nombre:String, apellidos:String, curso:String):
        Persona1(nombre, apellidos) {
        var curso:String

        init {
                this.curso = curso
        }

        override fun visualizar(){
                super.visualizar()
                println ("El nombre es $nombre")
                println("El curso es $curso")
        }
}