package com.ammd.martinezangel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultRegistry
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ammd.martinezangel.databinding.ActivityRegisterBinding
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var medicos = mutableListOf<Medico>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCode.setOnClickListener {
            val intent = Intent(this, InformacionActivity::class.java)
            resultActivity.launch(intent)
        }

        binding.btnExit.setOnClickListener { System.exit(0) }

        binding.btnCancel.setOnClickListener {
            binding.codeTil.editText?.text?.clear()
            binding.nameTil.editText?.text?.clear()
            binding.dniTil.editText?.text?.clear()
            binding.yearTil.editText?.text?.clear()
        }

        binding.btnRegister.setOnClickListener {
            if (validateFields() == 0)
                registerMedico()
        }

    }
    private var resultado: Especialidad? = null
    private val resultActivity=
        registerForActivityResult(ActivityResultRegis){

        }


    private fun registerMedico() {
        medicos.add(
            Medico(
                binding.dniTil.editText?.text.toString(),
                binding.nameTil.editText?.text.toString(),
                binding.yearTil.editText?.text.toString().toInt(),
                binding.codeTil.editText?.text.toString().toInt()
            )
        )
    }

    private fun validateFields(): Int {
        var valid = -4
        if (binding.dniTil.editText?.text?.length != 9)
            binding.dniTil.editText?.error = "Rellene correctamente."
        else {
            binding.dniTil.editText?.error = null
            valid++
        }

        if (binding.nameTil.editText?.text == null || binding.dniTil.editText?.text!!.isEmpty())
            binding.nameTil.editText?.error = "Faltan datos."
        else if (binding.nameTil.editText?.text!!.length > 50)
            binding.nameTil.editText?.error = "Límite de caracteres superado: máx. 50."
        else {
            binding.nameTil.editText?.error = null
            valid++
        }

        if (binding.yearTil.editText?.text == null || binding.dniTil.editText?.text!!.isEmpty())
            binding.yearTil.editText?.error = "Faltan datos."
        else {
            var year = binding.yearTil.editText?.text.toString().toInt()
            val date = Date()
            val yyyy = SimpleDateFormat("yyyy").format(date).toInt()
            if (year < yyyy - 2 || year > yyyy)
                binding.yearTil.editText?.error = "No puede acceder a esta especialidad. Causa: año de finalización."
            else {
                binding.yearTil.editText?.error = null
                valid++
            }
        }
        if (binding.codeTil.editText?.text == null || binding.dniTil.editText?.text!!.isEmpty())
            binding.codeTil.editText?.error = "Faltan datos."
        else {
            var year = binding.codeTil.editText?.text.toString().toInt()
            if (binding.codeTil.editText?.text?.length != 9)
                binding.codeTil.editText?.error = "Rellene correctamente"
            else {
                binding.codeTil.editText?.error = null
                valid++
            }
        }

        return valid
    }
}
