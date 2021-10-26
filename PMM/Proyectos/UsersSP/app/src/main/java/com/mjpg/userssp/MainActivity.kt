package com.mjpg.userssp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mjpg.userssp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var usuarioAdaptador: UsuarioAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuarioAdaptador = UsuarioAdapter(getUsuarios())
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter= usuarioAdaptador
        binding.recyclerview.layoutManager = linearLayoutManager
    }

    private fun getUsuarios(): MutableList<Usuario> {
        val usuarios = mutableListOf<Usuario>()

        usuarios.add(Usuario(1, "Maria", "Campos", ""))
        usuarios.add(Usuario(2, "Juan", "de la Vega", ""))
        usuarios.add(Usuario(3, "Marcos", "Prado", ""))
        usuarios.add(Usuario(4, "Susana", "Merino", ""))
        return usuarios
    }


}