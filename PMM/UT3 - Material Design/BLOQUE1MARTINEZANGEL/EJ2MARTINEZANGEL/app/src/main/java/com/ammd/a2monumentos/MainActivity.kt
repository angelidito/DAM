package com.ammd.a2monumentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ammd.a2monumentos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var monumentoAdaptador: MonumentoAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val monumentos = listOf(
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


        monumentoAdaptador = MonumentoAdapter(monumentos)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = monumentoAdaptador
        binding.recyclerview.layoutManager = linearLayoutManager
    }
}