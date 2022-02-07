package com.example.pedropaexamenprueba

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pedropaexamenprueba.databinding.ActivityInformacionBinding

class InformacionActivity : AppCompatActivity(), EventosListener {
    private lateinit var binding: ActivityInformacionBinding
    private lateinit var callAdapter: EspecialidadAdapter
    private lateinit var manager: RecyclerView.LayoutManager
    companion object{
        const val CODIGO =  "codigo"
        const val ANN = "annos"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInformacionBinding.inflate(layoutInflater)
        callAdapter = EspecialidadAdapter(getEspecialidad(), this)
        manager = LinearLayoutManager(this)
        binding.recyclerview.adapter = callAdapter
        binding.recyclerview.layoutManager = manager
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    private fun getEspecialidad(): List<Especialidad> {
        val especialidad1 = Especialidad(1, "Neurología", 2)
        val especialidad2 = Especialidad(2, "Trauma", 3)
        val especialidades: List<Especialidad> = listOf(especialidad1, especialidad2)
        return especialidades
    }
    override fun onLongClickListener(especialidad: Especialidad, posicion: Int) {
        val cod = especialidad.codigo
        val ann = especialidad.annos
        val intent = Intent()
        intent.putExtra(CODIGO,cod.toString())
        intent.putExtra(ANN,ann.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}