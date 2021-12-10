package com.ima.maesoivan

data class Medico(val dni:String, val nombreApellidos:String, val annoTit:Int, val codEsp:Int){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Medico

        if (dni != other.dni) return false

        return true
    }

    override fun hashCode(): Int {
        return dni.hashCode()
    }
}
