package com.mjpg.userssp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.circularreveal.CircularRevealLinearLayout
import com.google.android.material.snackbar.Snackbar
import com.mjpg.userssp.databinding.ActivityMainBinding
import java.sql.DriverManager

class MainActivity : AppCompatActivity(),EventosListener{


    private lateinit var binding: ActivityMainBinding
    private lateinit var usuarioAdaptador: UsuarioAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuarioAdaptador = UsuarioAdapter(getUsuario(),this)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = usuarioAdaptador
        binding.recyclerview.layoutManager = linearLayoutManager

    }

    private fun getUsuario():MutableList<Usuario>{
        val usuarios = mutableListOf<Usuario>()
        val usuario1 = Usuario(1,"Maria","Pardo","https://virgensantamaria.org/wp-content/uploads/2019/09/Nacimiento-Virgen-Maria-213x300.jpg");
        val usuario2 = Usuario(2,"Pepe","Gómez","https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Pepe_2018.jpg/245px-Pepe_2018.jpg");
        val usuario3 = Usuario(3,"Manuel","González","https://www.lecturas.com/medio/2021/01/22/manuel-la-isla-de-las-tentaciones_499582f9_800x800.jpg");
        val usuario4 = Usuario(4,"Sara","López","https://media.vogue.es/photos/60b510fa5433e76341c6baed/2:3/w_2560%2Cc_limit/WhoKilledSara__Season2_Episode3_00_21_31_12_R_.jpg");
        val usuario5 = Usuario(5,"Adrián","Fuente","https://media.fashionnetwork.com/cdn-cgi/image/fit=contain,width=1000,height=1000/m/0d2f/313d/73c9/143a/6875/d46e/d976/bb81/2b1d/b017/b017.jpg");
        val usuario6 = Usuario(6,"Roberto","Pérez","https://www.realmadrid.com/cs/Satellite?blobcol=urldata&blobheader=image%2Fjpeg&blobkey=id&blobtable=MungoBlobs&blobwhere=1203339998493&ssbinary=true");
        val usuario7 = Usuario(7,"Andrea","Martínez","https://www.lavanguardia.com/files/image_449_220/uploads/2020/12/17/5fdb624bd51a0.jpeg");
        val usuario8 = Usuario(8,"Paco","García","https://www.marketingdirecto.com/wp-content/uploads/2015/06/paco.jpg");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);
        usuarios.add(usuario5);
        usuarios.add(usuario6);
        usuarios.add(usuario7);
        usuarios.add(usuario8);
        return usuarios
    }

    override fun onClickListener(usuario: Usuario, posicion:Int) {
        intent= Intent(this,SegundaActividad::class.java)
        startActivity(intent)
        Toast.makeText(this,"El usuario es " + usuario.personalizado() + " posicion " + posicion.toString(),Toast.LENGTH_SHORT).show()
    }

}