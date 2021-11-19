package com.ammd.a2monumentos

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ammd.a2monumentos.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), EventosListener {


    private lateinit var binding: ActivityMainBinding
    private lateinit var monumentoAdaptador: MonumentoAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        monumentoAdaptador = MonumentoAdapter(getMonumentos(), this)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = monumentoAdaptador
        binding.recyclerview.layoutManager = linearLayoutManager

    }


    private fun getMonumentos(): List<Monumento> {
        return listOf(
            Monumento(
                "Cathedral",
                "Plaza de Santa María",
                "https://e00-elmundo.uecdn.es/elmundo/2021/graficos/jul/burgos/graf_cerrada-989.jpg",
                "catedral@burgos.com",
                "+34 654 112 356",
                "Bonita y bella como una estrella caida del mimso cielo."
            ),
            Monumento(
                "Arco",
                "Calle del arco",
                "https://www.decorarconarte.com/wp-content/uploads/2020/06/maquetas-Arco-de-Sta-Maria-Burgos-11x11x11cm.jpg",
                "arco@burgos.com",
                "678456321",
                "Un arco de a saber cuando, pero mucho tiempo, eso seguro."
            ),
            Monumento(
                "Plaza Mayor",
                "Plaza Mayor",
                "https://www.verpueblos.com/fotos_originales/3/7/3/01094373.jpg",
                "plazamayor@burgos.com",
                "687 45 98 45",
                "Una plaza, la mayor de la ciudad. Está en el centro. No se recomienda su visita."
            ),
            Monumento(
                "La Cartuja",
                "Miraflores",
                "https://3dwarehouse.sketchup.com/warehouse/v1.0/publiccontent/2e9d9049-dd5d-446e-a62d-2ea4e829753b",
                "cartuja@burgos.com",
                "654 11 23 56",
                "Hay monjes que dan miedo y asustan a los niños. En halloween se escuchan gritos que salen de su interior."
            )
        )
    }

    override fun onClickListenerCall(monumento: Monumento, posicion: Int) {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.CALL_PHONE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            Snackbar.make(
                binding.root,
                "Permiso no concedido",
                Snackbar.LENGTH_LONG
            ).show()
            if (
                ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.CALL_PHONE
                )
            ) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("¿Desea permitir a la aplicación realizar llamadas?")
                builder.setMessage("Pulse aceptar para poder llamar")
                builder.setPositiveButton("Aceptar")
                { _, _ ->
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CALL_PHONE),
                        123
                    )
                }
                builder.setPositiveButton("Denegar", null)
                builder.show()
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    123
                )
            }
        } else {
            Snackbar.make(
                binding.root,
                "Permiso concedido",
                Snackbar.LENGTH_LONG
            ).show()
            llamada(monumento.telefono)
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            123 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Snackbar.make(
                        binding.root,
                        "Acabas de conceder el permiso",
                        Snackbar.LENGTH_LONG
                    ).show()
                } else
                    Snackbar.make(
                        binding.root,
                        "No has concido el permiso",
                        Snackbar.LENGTH_LONG
                    ).show()
            }
            else ->
                Snackbar.make(
                    binding.root,
                    "NADA",
                    Snackbar.LENGTH_LONG
                ).show()
        }
    }

    private fun llamada(telefono: String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ telefono))
        startActivity(intent)
    }

    override fun onClickListenerEmail(monumento: Monumento, posicion: Int) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("mailto:" + monumento.email)
        )
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Snackbar.make(
                binding.root,
                "No se encuentra navegador",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}