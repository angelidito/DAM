package com.mjpg.mdcclase

import android.graphics.Color
import android.os.Bundle


import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.mjpg.mdcclase.databinding.ActivityScrollingBinding
import java.net.URL

class ScrollingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScrollingBinding
/*lateinit --> dice que no tiene ahora mismo un valor, pero más tarde te lo daré*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /* var bar1:FloatingActionButton
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_scrolling)

         bar1=findViewById<FloatingActionButton>(R.id.fab)
         bar1.setOnClickListener(){

             if (findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode==
                         BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                             findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode=
                                 BottomAppBar.FAB_ALIGNMENT_MODE_END
             else
                 findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode=
                     BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
         }*/
        binding.fab.setOnClickListener {
            if (findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode ==
                BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            )
                binding.bottomAppBar.fabAlignmentMode =
                    BottomAppBar.FAB_ALIGNMENT_MODE_END
            else
                binding.bottomAppBar.fabAlignmentMode =
                    BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        }


        binding.bottomAppBar.setNavigationOnClickListener {
            Snackbar.make(
                binding.root, getString(R.string.exito),
                Snackbar.LENGTH_LONG
            ).setAnchorView(binding.fab)
                .show()
        }
        binding.content.btnSkip?.setOnClickListener {
            binding.content.cvAd?.visibility = View.GONE
        }
        binding.content.btnBuy?.setOnClickListener {
            Snackbar.make(it, getString(R.string.comprando), Snackbar.LENGTH_SHORT)
                .setAction(getString(R.string.ir)) {
                    Toast.makeText(this, "probando", Toast.LENGTH_LONG).show()
                }
                .setAnchorView(binding.fab)
                .show()
        }

        cargarImagen()

        binding.content.cbEnablePass?.setOnClickListener {
            binding.content.tilPassword!!.isEnabled = !binding.content.tilPassword!!.isEnabled
        }
        binding.content.etUrl?.onFocusChangeListener = View.OnFocusChangeListener { view, focus ->
            View.OnFocusChangeListener { _, focus ->
                val url = binding.content.etUrl?.text.toString()
                var error: String? = null
                if (!focus) {
                    if (!url.isEmpty()) {
                        if (URLUtil.isValidUrl(url)) {
                            cargarImagen(url)
                        } else {
                            error = getString(R.string.urlincorrecta)

                        }
                    } else {
                        error = getString(R.string.requerido)
                    }
                    binding.content.tilUrl.error = error
                }
            }
        }
        binding.content.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            binding.content.root.setBackgroundColor(
                when(checkedId){
                    R.id.btnBlue-> Color.BLUE
                    R.id.btnRed -> Color.RED
                    else-> Color.GREEN
                }
            )

        }
    }

    private fun cargarImagen(url: String = "https://www.desarrollolibre.net/public/images/example/android/kotlin/kotlin_android.png") {

        Glide.with(this)
            .load(url)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.content.imgCover)

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}