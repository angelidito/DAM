package com.sde.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.sde.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    // Todo lo que vaya dentro del siguiente metodo son objetos estáticos (comunes a todo el proyecto). Solo se puede escribir una vez
    companion object{
        const val EXTRA_NOMBRE = "nombre"
        const val OBJETO = "usuario"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSend.setOnClickListener(escucharBoton)
    }
    var escucharBoton: View.OnClickListener = View.OnClickListener {
        val intent = Intent(this, SegundaActividad::class.java)
        intent.putExtra(EXTRA_NOMBRE, binding.textToSend2.text.toString())
        val usuario = Usuario("Maria", "López")
        intent.putExtra(OBJETO, usuario)
        //startActivity(intent)
        resultadoActividad.launch(intent)
    }

    // La actividad 1 llama a la Actividad 2. Cuando en la 2 se encuentre un 'finish' se vuelve
    // a la Actividad 1 y se ejecuta el siguiente código:
    val resultadoActividad = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
            if (result.resultCode == RESULT_OK){
                val data:Intent? = result.data
                val resultado = data?.getFloatExtra("valores", 0.0f)
                binding.tvResult.text = "Condiciones aceptadas. \nGracias por su valoración de $resultado estrellas"
            }
            else {
                binding.tvResult.text = "Condiciones canceladas"
            }
    }


}