package com.examen.martinezangel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ammd.martinezangel.CategoriaAdapter
import com.examen.martinezangel.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var database: EmpresaDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i = Intent(this, CategoriaAdapter::class.java)

        database = EmpresaDAO(this)

        binding.btnAcceder.setOnClickListener {
            val usuario = binding.loginTil.editText.toString()
            val contraseña = binding.passwordTil.editText.toString()

            if (usuario.isBlank() && contraseña.isBlank()) {
                intent.putExtra("usuario", "invitado")
                startActivity(intent)
            }

            var acceso = database.logIn(usuario, contraseña)

            if (acceso) {
                intent.putExtra("usuario", usuario)
                startActivity(intent)
            }
        }

    }

    override fun onResume() {
        super.onResume()
    }


}