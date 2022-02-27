package com.martinezangel.bd3.enventlisteners

import com.martinezangel.bd3.models.Producto

interface ProductoEventListener {
    fun onLongClickListener(producto: Producto)
}