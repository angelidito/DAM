package com.sde.ejerciciosut2delgado

import com.sde.ejerciciosut2delgado.Vehiculo3 as Motocicleta

class Motocicleta(marca:String, modelo:String, color:String, numpla:Int, maletero:Boolean): Motocicleta(marca, modelo, color) {
    var numpla:Int
    var maletero:Boolean

    init {
        this.numpla = numpla
        this.maletero = maletero
    }

    override fun visualizar(){
        super.visualizar()  // Con esta línea se sacan los datos del método visualizar de la clase Vehiculo3
        println ("El número de plazas es $numpla")
        println("¿Tiene maletero?: $maletero")
    }
}