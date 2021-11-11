package com.ammd.blackfriday

data class Usuario(val login: String, val contrasena: String) {

//    public fun validar(login: String, contrasena: String): Boolean {
//        return this.login == login && this.contrasena == contrasena
//    }

    override fun equals(other: Any?): Boolean {
        if (other === this)
            return true
        if (other == null || other.javaClass != this.javaClass)
            return false
        other as Usuario
        return login == other.login && this.contrasena == other.contrasena
    }

    override fun hashCode(): Int {
        var result = login.hashCode()
        result = 31 * result + contrasena.hashCode()
        return result
    }
}
