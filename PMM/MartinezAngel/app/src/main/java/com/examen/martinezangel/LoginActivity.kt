package com.examen.martinezangel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ammd.martinezangel.CategoriasAdapter
import com.examen.martinezangel.databinding.ActivityLoginBinding
import java.io.Console

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var database: EmpresaDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i = Intent(this, CategoriasAdapter::class.java)

        database = EmpresaDAO(this)

        binding.btnAcceder.setOnClickListener {
            val usuario = binding.loginTil.editText?.text.toString().trim()
            val contraseña = binding.passwordTil.editText?.text.toString().trim()
            intent = Intent(this, CategoriasActivity::class.java)

            if (usuario.isBlank() && contraseña.isBlank()) {
                intent.putExtra("usuario", "invitado")
                startActivity(intent)
            }

            var acceso = database.logIn(usuario, contraseña)

            println("Acceso: $acceso; usuario: $usuario; contraseña: $contraseña")

            if (acceso) {
                intent.putExtra("usuario", usuario)
                startActivity(intent)
                finish()
            }
        }

    }

    override fun onResume() {
        super.onResume()
    }


}