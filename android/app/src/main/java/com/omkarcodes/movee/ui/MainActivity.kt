package com.omkarcodes.movee.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.omkarcodes.movee.R
import com.omkarcodes.movee.comman.Constants
import com.omkarcodes.movee.databinding.ActivityMainBinding
import com.omkarcodes.movee.ui.detail.fragments.VideoPlayerActivity
import com.omkarcodes.movee.ui.detail.models.video.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Movee)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        navController = findNavController(R.id.navHostFragment)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.detailFragment){
                binding.bottomBar.visibility = View.GONE
            }else
                binding.bottomBar.visibility = View.VISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_bottom_bar,menu)
        binding.bottomBar.setupWithNavController(menu,navController)
        return true
    }

    fun playVideo(list: ArrayList<Result>) {
        binding.apply {
            startActivity(Intent(this@MainActivity,VideoPlayerActivity::class.java).apply {
                putParcelableArrayListExtra(Constants.TRAILER_LIST,list)
            })
        }
    }
}