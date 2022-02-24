package com.sde.delgadosergio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sde.delgadosergio.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var bd: TiendaDAO

    companion object {
        const val COD_USUARIO = "codUsuario"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = TiendaDAO(this)

        // Al pulsar el botón de Aceptar...
        binding.btnAceptar.setOnClickListener {
            // Variables con los datos introducidos por teclado
            val usuario = binding.txtLogin.text.toString().trim()
            val pass = binding.txtContra.text.toString().trim()

            // Si hay algún campo vacío
            if (usuario.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show()
            } else {
                val codUsuario = bd.consultaLogin(usuario, pass)

                if (codUsuario == "") {
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    // Se pasa el código del usuario
                    intent = Intent(this, ConsultaCategoriasActivity::class.java)
                    intent.putExtra(COD_USUARIO, codUsuario)
                    startActivity(intent)
                }
            }
        }

        binding.btnInvitado.setOnClickListener {
            intent = Intent(this, ConsultaCategoriasActivity::class.java)
            startActivity(intent)
        }
    }
}