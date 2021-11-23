package com.ammd.martinezangel


data class Medico(val dni: String, val name: String, val year: Int, val code: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Medico

        if (dni != other.dni) return false

        return true
    }
}
