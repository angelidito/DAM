package com.example.bd2E1ds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bd2E1ds.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var bd: BufeteDAO

    companion object{
        const val TIPO_USUARIO = "tipoUsu"
        const val NUM_ABOGADO = "numAbogado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = BufeteDAO(this)

        // Al pulsar el botón de Aceptar...
        binding.btnAceptar.setOnClickListener {
            // Variables con los datos introducidos por teclado
            val usuario = binding.txtLogin.text.toString()
            val pass =  binding.txtContra.text.toString()

            // Si hay algún campo vacío
            if(usuario.isEmpty() || pass.isEmpty()){
                Toast.makeText(this,"Rellene todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                val tipoUsuario = bd.consultaLogin(usuario, pass)
                val numAbogado = bd.consultaNumAbogado(usuario)

                if (tipoUsuario == ""){
                    Toast.makeText(this,"Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
                else {
                    // Si es administrador
                    if (tipoUsuario == "S"){
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
}