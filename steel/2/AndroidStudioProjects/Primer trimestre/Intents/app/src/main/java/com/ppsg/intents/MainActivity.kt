package com.ppsg.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.ppsg.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object{
        const val EXTRA_NOMBRE = "nombre"
        const val OBJETO="usuario"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSend.setOnClickListener(escucharBoton)
    }

    var escucharBoton: View.OnClickListener= View.OnClickListener {
        val intent=Intent(this, SegundaActividad::class.java)
        intent.putExtra(EXTRA_NOMBRE,binding.textToSend2.text.toString())
        val usuario=Usuario("Maria","Pardo")
        intent.putExtra(OBJETO, usuario)
        //startActivity(intent)
        //En lugar del start activity ponemos esto
        //lo que hace es: la actividad 1 llama a la actividad 2, cuando la actividad 2 esté en "finish"
        //vuelve a la actividad 1 y se ejecuta el siguiente código
        resultadoActividad.launch(intent)
    }

    val resultadoActividad=registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
            result->
                if(result.resultCode== RESULT_OK){
                    val data:Intent?=result.data
                    val resultado=data?.getFloatExtra("Valores",0.0f)
                    binding.tvResult.text="Condiciones aceptadas. \n Gracias por dar su valoración con $resultado"
                }else{
                    binding.tvResult.text="Se canceló"
                }
        }

}