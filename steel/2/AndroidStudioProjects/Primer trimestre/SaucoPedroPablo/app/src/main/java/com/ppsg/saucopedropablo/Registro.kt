package com.ppsg.saucopedropablo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.view.size
import com.ppsg.saucopedropablo.databinding.ActivityResgistroBinding

class Registro : AppCompatActivity() {

    private lateinit var binding: ActivityResgistroBinding
    var usuarios = mutableListOf<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResgistroBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var dni: String = binding.txtDni.toString()
        var nombre: String = binding.txtNombre.toString()
        var anno: String = binding.txtAnno.text.toString()
        var codigo: String = binding.txtCodigo.text.toString()

        //EL BOTON DE LA INFORMACIÓN
        binding.informacion.setOnClickListener {
            intent = Intent(this, Informacion::class.java)
            startActivity(intent)
        }

        //EL BOTON DE FINALIZAR
        binding.finalizar.setOnClickListener {
            finish()
        }

        //EL BOTON CANCELAR
        binding.cancelar.setOnClickListener {
            binding.txtDni.setText("")
            binding.txtAnno.setText("")
            binding.txtCodigo.setText("")
            binding.txtNombre.setText("")
        }

        //EL BOTON DE REGISTRAR
        binding.registrar.setOnClickListener {

            if (dni.isEmpty() && binding.dni.size > 9 && binding.dni.size < 9) {
                binding.txtDni.setError("DNI Incorrecto")
            } else if (nombre.isEmpty() && binding.nombre.size > 50) {
                binding.txtNombre.setError("Nombre Incorrecto")
            } else if (binding.anno.isEmpty() && binding.anno.size > 4 && binding.anno.size < 4) {
                binding.txtAnno.setError("Año Incorrecto")
            } else if (binding.codigo.isEmpty()) {
                binding.txtCodigo.setError("Falta Código")
            } else {
                agregarUsuarios(dni, nombre, anno, codigo)
                Toast.makeText(this, "Usuario creado", Toast.LENGTH_SHORT).show()
                binding.txtDni.setText("")
                binding.txtAnno.setText("")
                binding.txtCodigo.setText("")
                binding.txtNombre.setText("")
            }
        }
    }

    fun agregarUsuarios(dni: String, nombre: String, anno: String, codigo: String) {
        val usuario = Usuario(dni, nombre, anno, codigo)
        usuarios.add(usuario)
    }
}