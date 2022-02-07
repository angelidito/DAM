package com.example.recsaucopedropablo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recsaucopedropablo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        val usuario1 = Usuario("pp", "123",0)
        val usuario2 = Usuario("diego", "123",1)
        var usuarios = listOf<Usuario>(usuario1,usuario2)
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            var usu = binding.txtNombre.text.toString()
            var contra = binding.txtContra.text.toString()
            fun perfil():Int{
                var perfil:Int

                if( usu == "pp"){
                    perfil=0
                }else{
                    perfil=1
                }
                return perfil
            }
            var usuariovalidar = Usuario(usu, contra, perfil())
            if (usu.isEmpty() || contra.isEmpty()) {
                Toast.makeText(this, "HAY CAMPOS VACÍOS", Toast.LENGTH_SHORT).show()
            } else {
                var pos = usuarios.indexOf(usuariovalidar)
                if (pos == -1) {
                    Toast.makeText(this, "LOGIN O CONTRASEÑA INCORRECTO", Toast.LENGTH_SHORT).show()
                } else if(perfil()==0){
                    intent = Intent(this, MecanicoActividad::class.java)
                    startActivity(intent)
                }else{
                    intent = Intent(this, RecepcionistaActividad::class.java)
                    startActivity(intent)
                }
            }
        }
        binding.finalizar.setOnClickListener {
            finish()
        }
    }
    /*fun busquedanombre( medicos:MutableList<Persona>):Int{
        var encontrado=false
        var i=0
        while (i<medicos.size&&!encontrado){
            if (binding.txtdni.text.toString() == medicos.get(i).dni) {
                if (binding.txtnombreape.text.toString() == medicos.get(i).nombreApe) {
                        encontrado = true
                }
            }
            i++
        }
        return i
//despues añades el en el if donde le llamas al metodo
        val medico=medicos.get(i)
    }*/
}