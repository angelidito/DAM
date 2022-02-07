package com.ppsg.bd2saucopedropablo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ppsg.bd2saucopedropablo.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {

    private lateinit var db: BufeteDAO
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = BufeteDAO(this)

        //Debo hacer una select tipo from tabla_usuarios where nombre="" and contrasena= ""
        binding.btnLogin.setOnClickListener {
            val usuario = binding.txtNombre.text.toString()
            val contrasena = binding.txtContra.text.toString()
            var tipoUsu = ""

            tipoUsu = db.getTipoUsuario(usuario, contrasena)

            if (usuario.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Faltan campos por rellenar", Toast.LENGTH_LONG).show()
//              binding.txtContra.setError("FALTA USUARIO")
            } else if (tipoUsu == "") {
                Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show()
            } else if (tipoUsu == "A") {
                var numAbogado = ""
                //Aquí coges el número de abogado para los casos
                numAbogado = db.getNumAbogado(usuario,contrasena)
                //Si el usuario es de tipo abogado, le paso el tipo a la clase de CasosActivity para mostrar los casos de ese usuario
                intent = Intent(this, AbogadosActivity::class.java)
                intent.putExtra("numeroColegiado", numAbogado)
                startActivity(intent)
            } else if (tipoUsu == "S") {
                intent = Intent(this, AdministradorActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
//Toast.makeText(this,numAbogado, Toast.LENGTH_SHORT).show()