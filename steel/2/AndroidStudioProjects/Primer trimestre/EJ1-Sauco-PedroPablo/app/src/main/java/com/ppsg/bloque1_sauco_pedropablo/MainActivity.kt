package com.ppsg.bloque1_sauco_pedropablo

import android.app.ActivityManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ppsg.bloque1_sauco_pedropablo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Creas la lista de usuarios
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        //Creas los usuarios y los añades a la lista creada antes
        val usuario1 = Usuario("pp", "123")
        val usuario2 = Usuario("diego", "123")
        val usuarios: List<Usuario> = listOf(usuario1, usuario2)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //Cuando pulse el botón con id de aceptar pasará lo que hay dentro del método
        binding.aceptar.setOnClickListener {
            var usu = binding.txtUsu.text.toString()
            var contra = binding.txtContrasena.text.toString()


            //En este if y en el siguiente compruebas si los campos de texto están vacios,
            //de lo contrario si esos usuarios existen se logeara y si no te sacará un texto
            if (usu.isEmpty()) {
                binding.txtUsu.setError("FALTA USUARIO")
            } else if (contra.isEmpty()) {
                binding.txtContrasena.setError("FALTA CONTRASEÑA")
            } else {
                var usuariovalidar = Usuario(usu, contra)
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