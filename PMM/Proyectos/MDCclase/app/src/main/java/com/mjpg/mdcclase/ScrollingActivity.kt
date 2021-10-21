package com.mjpg.mdcclase

import android.os.Bundle


import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar
import com.mjpg.mdcclase.databinding.ActivityScrollingBinding

//import com.mjpg.mdcclase.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_scrolling)
//        var bar1: FloatingActionButton
//        bar1 = findViewById<FloatingActionButton>(R.id.fab)
//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
//            if (findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode
//                == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
//            )
//                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode =
//                    BottomAppBar.FAB_ALIGNMENT_MODE_END
//            else
////                if (findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_END)
//                findViewById<BottomAppBar>(R.id.bottom_app_bar).fabAlignmentMode =
//                    BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
//        }
        binding.fab.setOnClickListener {
            if (binding.bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            else
                binding.bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        }

        binding.bottomAppBar.setNavigationOnClickListener {
            Snackbar.make(
                binding.root,
                getString(R.string.mensaje_evento_exito),
                Snackbar.LENGTH_LONG
            ).setAnchorView(binding.fab).show()
        }

        binding.content.btnSkip.setOnClickListener {
            binding.content.cvAd.visibility = View.GONE
        }

        binding.content.btnBuy.setOnClickListener {
            Snackbar.make(it, R.string.texto_compra, Snackbar.LENGTH_SHORT)
                .setAction(getString(R.string.bbb)) {
                    Toast.makeText(this, "probando", Toast.LENGTH_LONG).show()
                }
                .setAnchorView(binding.fab)
                .show()
        }
        binding.content.imgCover.let {  //i.ytimg.com/vi/uNhAHzUpsXq/hqdefault.jpg
            Glide.with(this)
                .load("https://images.8tracks.com/cover/i/009/398/588/dgfhfh-331.jpg?rect=2,0,496,496&q=98&fm=jpg&fit=max")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(it)
        }
        binding.content.cbEnablePass.setOnClickListener {
            binding.content.tilPassword.isEnabled = !binding.content.tilPassword.isEnabled
        }
        val texto = binding.content.etUrl.text.toString()
        if (texto.isEmpty())
            ;
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