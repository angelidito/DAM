package com.example.bd2delgadosergio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bd2delgadosergio.databinding.ActivityNuevaGestionBinding
import java.text.SimpleDateFormat
import java.util.*

class NuevaGestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNuevaGestionBinding
    private lateinit var bd: BufeteDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuevaGestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = BufeteDAO(this)
        val numCaso = intent.getStringExtra(InfoCadaCaso.NUM_CASO).toString()

        binding.btnAceptar.setOnClickListener {
            // Variables con el dato introducido por teclado
            val descripcion = binding.txtDescripcion.text.toString()

            // Obtiene la fecha del sistema
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val date = Date()
            val fecha: String = dateFormat.format(date)

            // Si hay algún campo vacío
            if (descripcion.isEmpty()) {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                bd.nuevaGestion(numCaso, fecha, descripcion)
                Toast.makeText(this, "Gestión añadida correctamente!", Toast.LENGTH_LONG).show()

                binding.txtDescripcion.setText("")

                finish()
            }
        }

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}