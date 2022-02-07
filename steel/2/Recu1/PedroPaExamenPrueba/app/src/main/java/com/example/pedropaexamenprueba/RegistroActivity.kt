package com.example.pedropaexamenprueba

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isEmpty
import com.example.pedropaexamenprueba.databinding.ActivityMainBinding
import com.example.pedropaexamenprueba.databinding.ActivityRegistroBinding
import com.google.android.material.snackbar.Snackbar

class RegistroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding
    private val INFORMACION_REQUEST_CODE = 0
    private var annBase = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //BORRA LOS CAMPOS
        binding.cancelar.setOnClickListener {
            binding.txtDni.setText("")
            binding.txtAnno.setText("")
            binding.txtCod.setText("")
            binding.txtNombre.setText("")
            binding.error.setText("")
        }

        //TERMINA LA APLIACIÓN
        binding.finalizar.setOnClickListener {
            finish()
        }

        //DA INFORMACIÓN DEL CÓDIGO
        binding.info.setOnClickListener {
            intent = Intent(this, InformacionActivity::class.java)
            startActivity(intent)
        }

        //REGISTRA AL USUARIO
        binding.registrar.setOnClickListener {
            if (binding.txtDni.text.isNullOrBlank() || binding.txtNombre.text.isNullOrBlank() || binding.txtAnno.text.isNullOrBlank() || binding.txtCod.text.isNullOrBlank()) {
                binding.error.setText("Algún campo vacío")
            }else{
                val med= Persona(binding.txtDni.text.toString(),binding.txtNombre.text.toString() ,binding.txtAnno.text.toString().toInt() ,binding.txtCod.text.toString().toInt())
                if (getMedico().indexOf(med)==-1){
                    Snackbar.make(binding.root,"Medico registrado correctamente",Snackbar.LENGTH_LONG).show()
                    getMedico().add(med)
                    binding.txtDni.setText("")
                    binding.txtAnno.setText("")
                    binding.txtCod.setText("")
                    binding.txtNombre.setText("")
                    binding.error.setText("")
                }else {
                    binding.error.setText("Ya existe un medico con ese dni")
                }
            }
        }
    }

    private fun getMedico(): MutableList<Persona> {
        val enfermeros = mutableListOf<Persona>()
        val enfermero1 = Persona("12345678A", "Diego", 2, 1)
        val enfermero2 = Persona("87654321A", "Sergio", 2, 1)
        val enfermero3 = Persona("12345678B", "Pedro Pa", 2, 1)
        enfermeros.add(enfermero1)
        enfermeros.add(enfermero2)
        enfermeros.add(enfermero3)
        return enfermeros
    }

    //DEVUELVE EL CÓDIGO DE LA ESPECIALIDAD AL TXTCOD DEL XML
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == INFORMACION_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val cod = data!!.getStringExtra("codigo")
                binding.txtCod.setText(cod)
                val ann = data.getStringExtra("annos")
                annBase = ann!!.toInt()
            }
        }
    }
}