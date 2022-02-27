package com.martinezangel.bd3.enventlisteners

import com.martinezangel.bd3.models.Categoria

interface CategoriaEventListener {
    fun onClickListener(categoria: Categoria)

    fun onLongClickListener(categoria: Categoria)
}