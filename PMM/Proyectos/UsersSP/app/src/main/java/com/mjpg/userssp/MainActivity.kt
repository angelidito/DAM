package com.mjpg.userssp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mjpg.userssp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), EventosListener {


    private lateinit var binding: ActivityMainBinding
    private lateinit var usuarioAdaptador: UsuarioAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuarioAdaptador = UsuarioAdapter(getUsuarios(), this)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = usuarioAdaptador
        binding.recyclerview.layoutManager = linearLayoutManager
    }

    private fun getUsuarios(): MutableList<Usuario> {
        val usuarios = mutableListOf<Usuario>()

        usuarios.add(
            Usuario(
                1,
                "Maria",
                "Campos",
                "https://www.nationalgeographic.com.es/medio/2018/02/27/mariposas__1280x720.jpg"
            )
        )
        usuarios.add(
            Usuario(
                2,
                "Juan",
                "de la Vega",
                "https://mymodernmet.com/wp/wp-content/uploads/2020/07/Glasswing-Butterfly-with-Transparent-Wings-1.jpg"
            )
        )
        usuarios.add(
            Usuario(
                3,
                "Marcos",
                "Prado",
                "https://static.playgroundweb.com/wp-content/uploads/2021/05/playground_las_alas_de_las_mariposas_estan_perdiendo_colorido_por_la_deforestacion_2021.jpg"
            )
        )
        usuarios.add(
            Usuario(
                4,
                "Susana",
                "Merino",
                "https://static.malaga.es/malaga/subidas/imagenes/8/5/arc_252958_g.jpg"
            )
        )
        return usuarios
    }

    override fun onClickListener(usuario: Usuario, posicion:Int) {
        intent = Intent(this, Actividad2::class.java)
        startActivity(intent)

        Toast.makeText(
            this,
            "El usuario es " + usuario.personalizado() + " posición " + posicion.toString(), Toast.LENGTH_LONG
        ).show()
    }


}