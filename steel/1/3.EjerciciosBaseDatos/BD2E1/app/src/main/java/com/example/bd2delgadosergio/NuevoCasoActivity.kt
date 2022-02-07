package com.example.bd2delgadosergio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bd2delgadosergio.databinding.ActivityNuevoCasoBinding
import java.text.SimpleDateFormat
import java.util.*

class NuevoCasoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNuevoCasoBinding
    private lateinit var bd: BufeteDAO
    private lateinit var numAbogado:String
    private lateinit var tipoUsu:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuevoCasoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = BufeteDAO(this)

        tipoUsu = intent.getStringExtra(LoginActivity.TIPO_USUARIO).toString()

        numAbogado = intent.getStringExtra(LoginActivity.NUM_ABOGADO).toString()

        binding.btnAceptar.setOnClickListener {
            // Variables con el dato introducido por teclado
            val denominacion = binding.txtDenominacion.text.toString()
            val abogado = binding.txtAbogado.text.toString()
            val caracteristicas = binding.txtCaracteristicas.text.toString()

            // Obtiene la fecha del sistema
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val date = Date()
            val fecha: String = dateFormat.format(date)

            // Si hay algún campo vacío
            if (denominacion.isEmpty() || abogado.isEmpty() || caracteristicas.isEmpty()) {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val abogadoCorrecto = bd.consultaExisteAbogado(abogado)

                if (abogadoCorrecto){
                    bd.nuevoCaso(denominacion, fecha, caracteristicas, abogado.toInt())
                    Toast.makeText(this, "Caso añadido correctamente!", Toast.LENGTH_LONG).show()

                    binding.txtDenominacion.setText("")
                    binding.txtAbogado.setText("")
                    binding.txtCaracteristicas.setText("")

                    finish()
                }
                else {
                    Toast.makeText(this, "Ese abogado no existe :(", Toast.LENGTH_LONG).show()
                    binding.txtAbogado.setText("")
                }
            }
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}