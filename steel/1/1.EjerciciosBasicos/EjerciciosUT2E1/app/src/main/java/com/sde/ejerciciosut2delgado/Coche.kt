package com.sde.ejerciciosut2delgado

import com.sde.ejerciciosut2delgado.Vehiculo3 as Coche

class Coche (marca:String, modelo:String, color:String, numpuer:Int, numpla:Int): Coche(marca, modelo, color) {
    var numpuer:Int
    var numpla:Int

    init {
        this.numpuer = numpuer
        this.numpla = numpla
    }

    override fun visualizar(){
        super.visualizar()  // Con esta línea se sacan los datos del método visualizar de la clase Vehiculo3
        println ("El número de puertas es $numpuer")
        println("El número de plazas es $numpla")
    }
}