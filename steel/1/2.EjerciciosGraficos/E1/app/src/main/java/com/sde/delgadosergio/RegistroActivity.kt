package com.sde.delgadosergio

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.sde.delgadosergio.InformacionActivity.Companion.ESPECIALIDAD
import com.sde.delgadosergio.databinding.ActivityRegistroBinding
import java.text.SimpleDateFormat
import java.util.*

class RegistroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recibe la especialdiad sobre la que se ha hecho OnLongClick y pilla el codigo
        val especialidadRecibida: Especialidad? = intent.getParcelableExtra(ESPECIALIDAD)

        if (especialidadRecibida != null) {
            binding.txtCodigoEspecialidad.setText(especialidadRecibida.codigo)
        }

        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFinalizar.setOnClickListener {
            finish()
        }

        binding.btnCancelarSolicitud.setOnClickListener {
            binding.txtDNI.setText("")
            binding.txtNombreApell.setText("")
            binding.txtAnnoTitulacion.setText("")
            binding.txtCodigoEspecialidad.setText("")

        }

        binding.btnAyudaEspecialidad.setOnClickListener(escucharBoton)

        binding.btnRegistrarSolicitud.setOnClickListener {
            val dni = binding.txtDNI.text.toString()
            val nombreApell = binding.txtNombreApell.text.toString()
            val annoTitulacion = binding.txtAnnoTitulacion.text.toString()
            val codEspecialidad = binding.txtCodigoEspecialidad.text.toString()

            if (dni.isEmpty() || nombreApell.isEmpty() || annoTitulacion.isEmpty() || codEspecialidad.isEmpty()){
                Snackbar.make(binding.root, "RELLENE TODOS LOS CAMPOS", Snackbar.LENGTH_LONG).show()
            }
            else {
                try {
                    val fecha = Date()
                    val df = SimpleDateFormat("yyyy")
                    val anno = df.format(fecha)

                    val medicos = mutableListOf<Medicos>()
                    val medicoIntroducir = Medicos(dni, nombreApell, annoTitulacion.toInt(), codEspecialidad.toInt())
                    medicos.add(medicoIntroducir)
                    Snackbar.make(binding.root, "Añadido correctamente! :)", Snackbar.LENGTH_LONG).show()
                    binding.txtDNI.setText("")
                    binding.txtNombreApell.setText("")
                    binding.txtAnnoTitulacion.setText("")
                    binding.txtCodigoEspecialidad.setText("")
                }
                catch(nfe:NumberFormatException ){
                    Snackbar.make(binding.root, "El año de titulación y el código de especialidad deben ser numéricos!!", Snackbar.LENGTH_LONG).show()
                }
            }
        }

    }

    var escucharBoton: View.OnClickListener = View.OnClickListener {
        intent= Intent(this,InformacionActivity::class.java)
        resultadoActividad.launch(intent)
    }

    val resultadoActividad = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
        if (result.resultCode == RESULT_OK) {
            val data:Intent? = result.data
            val resultado = data?.getParcelableExtra<Especialidad>("especialidad")
            if (resultado != null) {
                binding.txtCodigoEspecialidad.setText(resultado.codigo)
            }
        }
        else {
            Snackbar.make(binding.root, "", Snackbar.LENGTH_SHORT).show()
        }
    }
}