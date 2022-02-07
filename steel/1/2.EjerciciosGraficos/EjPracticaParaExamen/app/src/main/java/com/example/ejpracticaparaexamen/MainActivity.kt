package com.example.ejpracticaparaexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejpracticaparaexamen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Crear los usuarios
        val usuario1 = Usuario("CR7", "123")
        val usuario2 = Usuario("LeoMessi", "123")
        val usuario3 = Usuario("Neymar Jr", "123")
        val usuarios: List<Usuario> = listOf(usuario1, usuario2, usuario3)

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Al pulsar el botón de Aceptar...
        binding.btnAceptar.setOnClickListener {
            // Variables con los datos introducidos por teclado
            var usuario = binding.txtLogin.text.toString()
            var pass =  binding.txtContra.text.toString()
            // Dato de tipo Usuario con la info introducida por teclado
            var usuarioValidado = Usuario(usuario,pass)

            // Si hay algún campo vacío
            if(usuario.isEmpty() || pass.isEmpty()){
                Toast.makeText(this,"Rellene todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                // Se recorre toda la lista de usuarios comparandola con el usuario validado
                var pos = usuarios.indexOf(usuarioValidado)
                // Si no hay ninguno que coincida con el introducido devuelve -1
                if(pos ==  -1){
                    Toast.makeText(this,"Login o Contraseña incorrecto", Toast.LENGTH_SHORT).show()
                }
                // Si encuentra al usuario se avanza a la siguiente pestaña
                else{
                    intent = Intent(this, IntroducirCodigo::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}