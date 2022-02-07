package com.example.bd3delgadosergio.EventosListener

import com.example.bd3delgadosergio.Pojos.Categoria

interface EventosListener {
    fun onClickListener(categoria: Categoria)

    fun onLongClickListener(categoria: Categoria)
}