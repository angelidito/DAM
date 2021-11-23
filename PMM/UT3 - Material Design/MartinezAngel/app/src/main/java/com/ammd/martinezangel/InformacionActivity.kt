package com.ammd.martinezangel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ammd.martinezangel.databinding.ActivityInformacionBinding
import com.ammd.martinezangel.databinding.ActivityInicioBinding
import com.ammd.martinezangel.databinding.ActivityListaEspecialidadesBinding
import com.ammd.martinezangel.databinding.ActivityRegisterBinding

class InformacionActivity : AppCompatActivity(), EventosListener {

    private lateinit var especialidadAdapter: EspecialidadAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityInformacionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var lista = listOf(
            Especialidad(1, "Cirujano", 2),
            Especialidad(2, "Neurologo", 6)
        )
        especialidadAdapter = EspecialidadAdapter(lista, this)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = especialidadAdapter
        binding.recyclerview.layoutManager = linearLayoutManager
    }

    override fun onLongClickListenerCall(code: Int, years: Int) {
//        val intent = Intent(this, RegisterActivity::class.java)
//
//        intent.putExtra("code", code)
//        intent.putExtra("years", years)
//        ?¿?¿?.launch(intent)
    }
}