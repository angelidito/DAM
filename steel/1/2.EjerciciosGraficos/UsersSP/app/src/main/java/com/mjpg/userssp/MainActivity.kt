package com.mjpg.userssp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mjpg.userssp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),EventosListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var usuarioAdaptador:UsuarioAdapter
    private lateinit var linearlayoutManager:RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuarioAdaptador= UsuarioAdapter(getUsuario(),this)
        linearlayoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = usuarioAdaptador
        binding.recyclerview.layoutManager = linearlayoutManager
    }

    private fun getUsuario():MutableList<Usuario>{
        val usuarios = mutableListOf<Usuario>()
        val usuario1 = Usuario(1,"Cristiano","Ronaldo","https://www.pngarts.com/files/5/Cristiano-Ronaldo-Transparent-Image.png")
        val usuario2 = Usuario(2,"Kylian","Mbappé","https://futbolete.com/apuestas/wp-content/uploads/2021/06/Kylian-Mbappe-PNG-Transparent-Image.png")
        val usuario3 = Usuario(3,"Neymar","Jr","https://e00-co-marca.uecdn.es/claro/assets/multimedia/imagenes/2021/09/06/16309320770461.jpg")
        val usuario4 = Usuario(4,"Lionel","Messi","https://image.pngaaa.com/328/892328-middle.png")
        usuarios.add(usuario1)
        usuarios.add(usuario2)
        usuarios.add(usuario3)
        usuarios.add(usuario4)
        return usuarios
    }

    override fun onClickListener(usuario: Usuario, posicion:Int){
        intent= Intent(this,SegundaActividad::class.java)
        startActivity(intent)
        Toast.makeText(this,"Ha seleccionado al usuario " + usuario.personalizado() + " de la posicion " + posicion.toString(), Toast.LENGTH_LONG).show()
    }
}