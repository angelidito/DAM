package com.ima.maesoivan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import com.ima.maesoivan.databinding.ActivityMainBinding
import com.ima.maesoivan.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding
    private val INFORMACION_REQUEST_CODE = 0
    private var annBase = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registrar.setOnClickListener {
            if(binding.inputtxt1.text.isNullOrBlank() || binding.inputtxt2.text.isNullOrBlank() || binding.inputtxt3.text.isNullOrBlank() || binding.inputtxt4.text.isNullOrBlank())
                Snackbar.make(binding.root,"Todos los campos son requeridos",Snackbar.LENGTH_LONG).show()
            else if(annBase < binding.inputtxt3.text.toString().toInt())
                Snackbar.make(binding.root,"Los años de titulacion son mayores que los máximos",Snackbar.LENGTH_LONG).show()
            else{
                val med= Medico(binding.inputtxt1.text.toString(),binding.inputtxt2.text.toString(),binding.inputtxt3.text.toString().toInt(),binding.inputtxt4.text.toString().toInt())
                if (getMedico().indexOf(med)==-1){
                    Snackbar.make(binding.root,"Medico registrado correctamente",Snackbar.LENGTH_LONG).show()
                    getMedico().add(med)
                }else
                    Snackbar.make(binding.root,"Ya existe un medico con ese dni",Snackbar.LENGTH_LONG).show()
            }
        }

        binding.cancelar.setOnClickListener {
            binding.inputtxt1.setText("")
            binding.inputtxt2.setText("")
            binding.inputtxt3.setText("")
            binding.inputtxt4.setText("")
        }

        binding.finalizar.setOnClickListener {
            this.finishAffinity()
        }

        binding.info.setOnClickListener {
            intent = Intent(this, Informacion::class.java)
            startActivityForResult(intent,INFORMACION_REQUEST_CODE)
        }
    }

    private fun getMedico(): MutableList<Medico>{
        val meds = mutableListOf<Medico>()
        val med1 =Medico("83749576A","Mari Pili Gonzalez",2,1)
        val med2 =Medico("91658774E","Pepe Ortiz",2,1)
        val med3 =Medico("36529937M","Pablo Rodriguez",2,1)
        meds.add(med1)
        meds.add(med2)
        meds.add(med3)
        return meds
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check that it is the SecondActivity with an OK result
        if (requestCode == INFORMACION_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                val cod = data!!.getStringExtra("codigo")
                binding.inputtxt4.setText(cod)
                val ann = data.getStringExtra("annos")
                annBase = ann!!.toInt()
            }
        }
    }
}