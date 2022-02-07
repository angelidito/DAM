package com.example.recsaucopedropablo

data class Usuario(var login:String, var contrasena:String, val perfil:Int) {
    fun personalizado():String="$login $contrasena $perfil"
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Usuario

        if (login != other.login) return false
        if (contrasena != other.contrasena) return false
        if (perfil != other.perfil) return false

        return true
    }

    override fun hashCode(): Int {
        var result = login.hashCode()
        result = 31 * result + contrasena.hashCode()
        result = 31 * result + perfil
        return result
    }
}