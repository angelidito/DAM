package com.example.ejerciciopruebas

data class Usuario(var name: String, var contrasena:String){
    fun personalizado():String="$name $contrasena"
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Usuario

        if (name != other.name) return false
        if (contrasena != other.contrasena) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + contrasena.hashCode()
        return result
    }

}
