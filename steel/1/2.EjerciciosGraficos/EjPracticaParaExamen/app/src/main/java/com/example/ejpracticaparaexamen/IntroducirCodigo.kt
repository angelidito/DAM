package com.example.ejpracticaparaexamen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejpracticaparaexamen.databinding.ActivityIntroducirCodigoBinding

class IntroducirCodigo : AppCompatActivity() {
    private lateinit var binding: ActivityIntroducirCodigoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Creas los monumentos
        val monumento1 = Monumento(
            "001",
            "https://viajes.nationalgeographic.com.es/medio/2020/11/05/ocho-siglos-de-historia_4272e68f_2000x1336.jpg",
            "Catedral de Burgos",
            "Plaza de Santa María, s/n, 09003 Burgos",
            "947 20 47 12",
            "info@catedraldeburgos.es",
            "La Catedral de Burgos es un templo catedralicio de culto católico dedicado a la Virgen María. Su construcción comenzó en 1221, siguiendo patrones góticos franceses. Tuvo importantísimas modificaciones en los siglos XV y XVI: las agujas de la fachada principal, la capilla del Condestable y el cimborrio del crucero. Las últimas obras de importancia pertenecen al siglo XVIII"
        )
        val monumento2 = Monumento(
            "002",
            "https://www.terranostrum.es/images/content/full/arco-santa-maria-burgos-1.jpg",
            "Arco de Santa María",
            "Plaza del Rey San Fernando s/n, 09003 Burgos",
            "947 28 88 68",
            "info@arcosantamaria.es",
            "El Arco de Santa María es uno de los monumentos más emblemáticos de la ciudad de Burgos. Es una de las antiguas doce puertas de acceso a la ciudad en la Edad Media y comunica el puente de Santa María, sobre el río Arlanzón, con la plaza del Rey San Fernando, donde se ubica la Catedral"
        )
        val monumento3 = Monumento(
            "003",
            "https://upload.wikimedia.org/wikipedia/commons/6/68/Cartuja_de_Miraflores.JPG",
            "Cartuja de Miraflores",
            "Pje. Fuentes Blancas, Km 3.5, 09002 Burgos",
            "947 25 25 86",
            "cartuja@miraflores.es",
            "La Cartuja de Santa María de Miraflores es un monasterio de la Orden de los Cartujos. Es una joya del arte gótico final. En el conjunto destaca la Iglesia, cuya portada occidental, en estilo gótico isabelino, está decorada con los escudos de sus fundadores. El templo es de una sola nave, capillas laterales y ábside poligonal. La nave está cubierta con bóveda estrellada"
        )
        val monumento4 = Monumento(
            "004",
            "https://upload.wikimedia.org/wikipedia/commons/f/f7/Casa_Del_Cord%C3%B3n_Fachada_Sur.JPG",
            "Casa del Cordón",
            "Plaza de la Libertad s/n, 09004 Burgos",
            "947 25 17 91",
            "info@casacordon.es",
            "El palacio de los Condestables de Castilla, conocido como la Casa del Cordón, es un palacio originario del Siglo XV que se alza en el casco histórico de Burgos, presidiendo la antigua plaza del Mercado Mayor. Sus promotores fueron los condestables de Castilla: Don Pedro Fernández de Velasco y la condesa Mencía de Mendoza y Figueroa"
        )
        val monumento5 = Monumento(
            "005",
            "https://upload.wikimedia.org/wikipedia/commons/2/24/Castillo_de_Olmillos_de_Sasam%C3%B3n.Burgos.jpg",
            "Castillo de Burgos",
            "Cerro de San Miguel, s/n, 09004 Burgos",
            "947 28 88 74",
            "info@castilloburgos",
            "El castillo de Burgos es una fortaleza situada en la cumbre del cerro del Castillo, elevado 75m sobre el nivel de la ciudad. La primera torre fue levantada por el conde Diego Porcelos en los tiempos de la Reconquista, en el año 884. Conforme fue aumentando la importancia del emplazamiento defensivo, se dio paso a un castillo más complejo y a unos elementos defensivos más sofisticados"
        )
        val monumentos: List<Monumento> =
            listOf(monumento1, monumento2, monumento3, monumento4, monumento5)

        super.onCreate(savedInstanceState)

        binding = ActivityIntroducirCodigoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Al pulsar el botón de Aceptar...
        binding.btnAceptar.setOnClickListener {
            // Variable con el código introducido por teclado
            val codMonum = binding.txtMonumento.text.toString()

            // Si el campo del código está vacío
            if (codMonum.isEmpty()) {
                Toast.makeText(this, "Introduzca el código del monumento", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // Boolean para el posible mensaje de error
                var encontrado = false
                // Recorre toda la lista de productos
                for (i in 0 until monumentos.size) {
                    // Si el código introducido está en la lista de monumentos
                    if (monumentos[i].codigo == codMonum) {
                        val monumento = monumentos[i]
                        intent= Intent(this,ActivityInfoMonumento::class.java)
                        intent.putExtra(MONUMENTO, monumento)
                        startActivity(intent)

                        encontrado = true
                    }
                }
                // Si no entra al if (No encuentra el producto)
                if (!encontrado) {
                    Toast.makeText(this, "Código del monumento incorrecto", Toast.LENGTH_SHORT).show()
                    binding.txtMonumento.setText("")
                }
            }
        }
    }

    companion object{
        const val MONUMENTO = "monumento"
    }
}