package com.ppsg.bloque1_sauco_pedropablo

import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import android.os.Bundle
import com.ppsg.bloque1_sauco_pedropablo.databinding.ActivitySegundaActividadBinding


class SegundaActividad : AppCompatActivity() {
    //Creamos la lista de productos
    var productos = mutableListOf<Producto>()
    private lateinit var binding: ActivitySegundaActividadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //Creamos los productos
        binding = ActivitySegundaActividadBinding.inflate(layoutInflater)
        val producto1 = Producto(
            1,
            "Balón",
            "data:image/png;base64,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",
            "https://www.amazon.es/Spalding-Outdoor-83-494Z-Baloncesto-Naranja/dp/B06WD43JNK/ref=asc_df_B06WD43JNK/?tag=googshopes-21&linkCode=df0&hvadid=199482218592&hvpos=&hvnetw=g&hvrand=89501059526905560&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1005450&hvtargid=pla-305405952219&th=1&psc=1"
        )
        val producto2 = Producto(
            2,
            "Telefono",
            "https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcSfqTF1Eq9fpoMJ-QBLD6jW0NVTGoPcUUxgF1PUcIeh0YgoPZi_6XgHT9eZaVhjBGsRs6tZc8HxfUA&usqp=CAc",
            "https://www.mediamarkt.es/es/product/_m%C3%B3vil-xiaomi-redmi-9-morado-64-gb-4-gb-6-53-full-hd-mediatek-helio-g80-quad-cam-5020-mah-android-1481074.html?utm_source=google&utm_medium=cpc&utm_campaign=MM_ES_SEARCH_GOOGLE_CATEGORIES_PLA_PLA-SMART-PH_PROMO_ALL_ALL&gclid=CjwKCAjwz5iMBhAEEiwAMEAwGPvw4u0z-Mo7av-fEPG9lLSOfAD5ebj8sHSCMUn2pOaFXT4lCD1ZLRoCDcMQAvD_BwE&gclsrc=aw.ds"
        )
        val producto3 = Producto(
            3,
            "Bugatti Chiron",
            "https://prod.pictures.autoscout24.net/listing-images/c413ab08-1a1e-4cec-a844-c6e1399f03a3_be080c9f-3d7c-4d82-ac8f-ae9a97522933.jpg/640x480.jpg",
            "https://www.autoscout24.es/anuncios/bugatti-chiron-gasolina-plateado-c413ab08-1a1e-4cec-a844-c6e1399f03a3?cldtidx=1&sort=standard&lastSeenGuidPresent=false&cldtsrc=listPage"
        )
        val producto4 = Producto(
            4,
            "Chalet Salou",
            "https://res.listglobally.com/listings/5826196/73183173/7768867d4b8d4d0bcd626db77fb60964?mode=max&w=1920",
            "https://www.properstar.es/listing/73183173?gclid=CjwKCAiA1aiMBhAUEiwACw25McwooHc0Srit1jvjrlpuFPB1Jr2HIexVMYSv_FcB3A2qdKOlPF5PMRoCiNEQAvD_BwE"
        )
        //Alto cumbiote que tiene nivelote
        productos.add(producto1)
        productos.add(producto2)
        productos.add(producto3)
        productos.add(producto4)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buscar.setOnClickListener {
            val codigo = binding.txtProducto.text.toString()
            //val codigobueno = codigo.toInt()
            var buscar = false

            if (codigo.isEmpty()) {
                binding.txtProducto.setError("Falta Código")
            } else {
                try {
                    val cod = Integer.parseInt(codigo)
                    var i = 0
                    var encontrado = false
                    while (!encontrado &&  i< productos.size) {
                        if (cod == productos[i].codigo) {
                            //Te muestra la imagen
                            Glide.with(binding.root)
                                .load(productos.get(i).imagen)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(binding.imagen)
                            binding.nombre.text = productos[i].nombre
                            binding.url.text = productos[i].url
                            buscar = true
                        }
                        i++
                    }
                    if (!buscar) {
                        binding.txtProducto.setError("Código no existente")
                        binding.imagen.setImageResource(android.R.color.transparent)
                        binding.nombre.setText("")
                        binding.url.setText("")
                    }

                } catch (ex: NumberFormatException) {
                    binding.txtProducto.setError("Debe ser numérico")
                }
            }
        }
    }
}