package com.ppsg.bloque1_sauco_pedropablo

import android.app.ActivityManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ppsg.bloque1_sauco_pedropablo.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), EventosListener {
    var usuarios = mutableListOf<Usuario>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val usuario1 = Usuario("pp", "123")
        val usuario2 = Usuario("diego", "123")
        usuarios.add(usuario1)
        usuarios.add(usuario2)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.aceptar.setOnClickListener {
            var usu = binding.txtUsu.text.toString()
            var contra = binding.txtContrasena.text.toString()
            var usuariovalidar = Usuario(usu, contra)

            if (usu.isEmpty() || contra.isEmpty()) {
                Toast.makeText(this, "HAY CAMPOS VACÍOS", Toast.LENGTH_SHORT).show()
            } else {
                var pos = usuarios.indexOf(usuariovalidar)
                if (pos == -1) {
                    Toast.makeText(this, "LOGIN O CONTRASEÑA INCORRECTO", Toast.LENGTH_SHORT).show()
                } else {
                    intent = Intent(this, SegundaActividad::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    override fun onClickListener(usuario: Usuario, posicion: Int) {

    }


}