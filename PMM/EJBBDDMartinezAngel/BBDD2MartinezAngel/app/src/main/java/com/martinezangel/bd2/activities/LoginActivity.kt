package com.martinezangel.bd2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.martinezangel.bd2.bd.BufeteDAO
import com.martinezangel.bd2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var database: BufeteDAO

    companion object {
        const val TIPO_USUARIO = "tipoUsu"
        const val NUM_ABOGADO = "numAbogado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = BufeteDAO(this)

        binding.btnAcceder.setOnClickListener {
            intentarAcceso()
        }
    }

    private fun intentarAcceso() {
        val usuario = binding.txtUsuario.text.toString()
        val contrasena = binding.txtContrasena.text.toString()

        if (usuario.isEmpty() || contrasena.isEmpty())
            Toast.makeText(this, "Rellene todos los campos, por favor.", Toast.LENGTH_SHORT).show()
        else {
            val tipoUsuario = database.logIn(usuario, contrasena)
            val numAbogado = database.consultaNumAbogado(usuario)

            if (tipoUsuario == "") {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            } else {
                // Si es administrador
                if (tipoUsuario == "S") {
                    intent = Intent(this, CasosActivity::class.java)
                    intent.putExtra(TIPO_USUARIO, tipoUsuario)
                    intent.putExtra(NUM_ABOGADO, numAbogado.toString())
                    startActivity(intent)
                }
                // Si es abogado
                else {
                    intent = Intent(this, CasosActivity::class.java)
                    intent.putExtra(TIPO_USUARIO, tipoUsuario)
                    intent.putExtra(NUM_ABOGADO, numAbogado.toString())
                    startActivity(intent)
                }
            }
        }

    }
}