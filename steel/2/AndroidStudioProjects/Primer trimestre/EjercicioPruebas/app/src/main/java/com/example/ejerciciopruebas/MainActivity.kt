package com.example.ejerciciopruebas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejerciciopruebas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Creas la lista de usuarios
    var usuarios = mutableListOf<Usuario>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Creas los usuarios y los añades a la lista creada antes
        val usuario1 = Usuario("pp", "123")
        val usuario2 = Usuario("alde-ano", "123")
        usuarios.add(usuario1)
        usuarios.add(usuario2)
        super.onCreate(savedInstanceState)
        //No lo se pero es importante
        setContentView(binding.root)

        binding.aceptar.setOnClickListener {
            var usu = binding.txtUsu.text.toString()
            var contra = binding.txtContrasena.text.toString()
            var usuariovalidar = Usuario(usu, contra)

            //En este if y en el siguiente compruebas si los campos de texto están vacios,
            //de lo contrario si esos usuarios existen se logeara y si no te sacará un texto
            if (usu.isEmpty()){
                binding.txtUsu.setError("FALTA USUARIO")
            }else if(contra.isEmpty()){
                binding.txtContrasena.setError("FALTA CONTRASEÑA")
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

}