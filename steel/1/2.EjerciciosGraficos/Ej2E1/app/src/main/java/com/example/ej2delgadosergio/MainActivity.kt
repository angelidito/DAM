package com.example.ej2delgadosergio

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ej2delgadosergio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), EventosListener{
    private lateinit var monumentoCall:Monumento
    private lateinit var binding: ActivityMainBinding
    private lateinit var monumentoAdaptador:MonumentoAdapter
    private lateinit var linearlayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        monumentoAdaptador = MonumentoAdapter(getMonumentos(), this)
        linearlayoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = monumentoAdaptador
        binding.recyclerView.layoutManager = linearlayoutManager
    }

    private fun getMonumentos(): List<Monumento> {
        // Creas los monumentos
        val monumento1 = Monumento(
            "https://viajes.nationalgeographic.com.es/medio/2020/11/05/ocho-siglos-de-historia_4272e68f_2000x1336.jpg",
            "Catedral de Burgos",
            "Plaza de Santa María, s/n, 09003 Burgos",
            "947 20 47 12",
            "info@catedraldeburgos.es",
            "La Catedral de Burgos es un templo catedralicio de culto católico dedicado a la Virgen María. Su construcción comenzó en 1221, siguiendo patrones góticos franceses. Tuvo importantísimas modificaciones en los siglos XV y XVI: las agujas de la fachada principal, la capilla del Condestable y el cimborrio del crucero. Las últimas obras de importancia pertenecen al siglo XVIII"
        )
        val monumento2 = Monumento(
            "https://www.terranostrum.es/images/content/full/arco-santa-maria-burgos-1.jpg",
            "Arco de Santa María",
            "Plaza del Rey San Fernando s/n, 09003 Burgos",
            "947 28 88 68",
            "info@arcosantamaria.es",
            "El Arco de Santa María es uno de los monumentos más emblemáticos de la ciudad de Burgos. Es una de las antiguas doce puertas de acceso a la ciudad en la Edad Media y comunica el puente de Santa María, sobre el río Arlanzón, con la plaza del Rey San Fernando, donde se ubica la Catedral"
        )
        val monumento3 = Monumento(
            "https://upload.wikimedia.org/wikipedia/commons/6/68/Cartuja_de_Miraflores.JPG",
            "Cartuja de Miraflores",
            "Pje. Fuentes Blancas, Km 3.5, 09002 Burgos",
            "947 25 25 86",
            "cartuja@miraflores.es",
            "La Cartuja de Santa María de Miraflores es un monasterio de la Orden de los Cartujos. Es una joya del arte gótico final. En el conjunto destaca la Iglesia, cuya portada occidental, en estilo gótico isabelino, está decorada con los escudos de sus fundadores. El templo es de una sola nave, capillas laterales y ábside poligonal. La nave está cubierta con bóveda estrellada"
        )
        val monumento4 = Monumento(
            "https://upload.wikimedia.org/wikipedia/commons/f/f7/Casa_Del_Cord%C3%B3n_Fachada_Sur.JPG",
            "Casa del Cordón",
            "Plaza de la Libertad s/n, 09004 Burgos",
            "947 25 17 91",
            "info@casacordon.es",
            "El palacio de los Condestables de Castilla, conocido como la Casa del Cordón, es un palacio originario del Siglo XV que se alza en el casco histórico de Burgos, presidiendo la antigua plaza del Mercado Mayor. Sus promotores fueron los condestables de Castilla: Don Pedro Fernández de Velasco y la condesa Mencía de Mendoza y Figueroa"
        )
        val monumento5 = Monumento(
            "https://upload.wikimedia.org/wikipedia/commons/2/24/Castillo_de_Olmillos_de_Sasam%C3%B3n.Burgos.jpg",
            "Castillo de Burgos",
            "Cerro de San Miguel, s/n, 09004 Burgos",
            "947 28 88 74",
            "info@castilloburgos",
            "El castillo de Burgos es una fortaleza situada en la cumbre del cerro del Castillo, elevado 75m sobre el nivel de la ciudad. La primera torre fue levantada por el conde Diego Porcelos en los tiempos de la Reconquista, en el año 884. Conforme fue aumentando la importancia del emplazamiento defensivo, se dio paso a un castillo más complejo y a unos elementos defensivos más sofisticados"
        )
        return listOf(monumento1, monumento2, monumento3, monumento4, monumento5)
    }

    companion object{
        const val MONUMENTO = "monumento"
    }

    // Al pulsar sobre cada tarjeta, pasa lo siguiente...
    override fun onLongClickListener(monumento: Monumento) {
        intent= Intent(this,InfoMonumentosActivity::class.java)
        intent.putExtra(MONUMENTO, monumento)
        startActivity(intent)
    }

    override fun onClickLlamar(monumento: Monumento) {
        monumentoCall = monumento
        // Si el permiso no está aceptado
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Muestra el mensaje explicando el permiso
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)
            ) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Permiso Necesario")
                builder.setMessage("Este permiso sirve para realizar llamadas \nDebe ser aceptado")
                // Si aceptas el mensaje se muestra la ventana propia de aceptar el permiso
                builder.setPositiveButton("Aceptar") {
                        _, _ -> ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 123)
                }
                // Si cancelas el permiso se cierra esa ventana
                builder.setNegativeButton("Cancelar", null)
                builder.show()
            }
            // Se muestra la ventana propia de aceptar el permiso
            else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 123)
            }
        }
        // Si el permiso ya estaba concedido, llama al método de realizar la llamada
        else {
            llamada()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            123 -> {
                // Si aceptas el permiso
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    llamada()
                }
                // Si cancelas el permiso
                else
                    Snackbar.make(binding.root, "Permiso no concedido :(", Snackbar.LENGTH_LONG).show()
            }
            else -> Snackbar.make(binding.root, "", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun llamada() {
        //El "tel:" sirve para que pille el número de teléfono correctamente
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + monumentoCall.telefono))
        startActivity(intent)
    }

    override fun onClickEmail(monumento: Monumento) {
        val mail = arrayOf(monumento.email)
        val intentEmail = Intent(Intent.ACTION_SEND)
        intentEmail.type = "text/plain"
        intentEmail.putExtra(Intent.EXTRA_EMAIL, mail)
        startActivity(Intent.createChooser(intentEmail, "Enviar email"))
    }
}