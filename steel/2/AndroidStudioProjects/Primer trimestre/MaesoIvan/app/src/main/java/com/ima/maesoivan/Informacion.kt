package com.ima.maesoivan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ima.maesoivan.databinding.ActivityInformacionBinding

class Informacion : AppCompatActivity(), Eventoslistener {
    private lateinit var binding: ActivityInformacionBinding
    private lateinit var espAdaptador: EspecialidadAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    companion object{
        const val CODIGO =  "codigo"
        const val ANN = "annos"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        espAdaptador = EspecialidadAdapter(getEspecificaciones(),this)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = espAdaptador
        binding.recyclerview.layoutManager = linearLayoutManager
    }

    private fun getEspecificaciones(): List<Especialidad>{
        val esps: List<Especialidad> = listOf(Especialidad(1,"Cirugia",3),Especialidad(2,"Estetica",5),Especialidad(3,"Psicologo",2))
        return esps
    }

    override fun onLongClickListener(especialidad: Especialidad, posicion: Int) {
        val cod = especialidad.codEsp
        val ann = especialidad.annosMaxEsp
        val intent = Intent()
        intent.putExtra(CODIGO,cod.toString())
        intent.putExtra(ANN,ann.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}