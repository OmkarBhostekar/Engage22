package com.omkarcodes.movee.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.tabs.TabLayout
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

        binding.apply {

            navController = findNavController(R.id.navHostFragment)

            navController.addOnDestinationChangedListener { controller, destination, arguments ->
                if (destination.id == R.id.detailFragment){
                    tabLayout.visibility = View.GONE
                }else
                    tabLayout.visibility = View.VISIBLE
                when(destination.id){
                    R.id.homeFragment -> tabLayout.selectTab(tabLayout.getTabAt(0))
                    R.id.forYouFragment -> tabLayout.selectTab(tabLayout.getTabAt(1))
                    R.id.savedFragment -> tabLayout.selectTab(tabLayout.getTabAt(2))
                    else -> Unit
                }
            }

            tabLayout.addTab(tabLayout.newTab().apply { text = "Home" })
            tabLayout.addTab(tabLayout.newTab().apply { text = "For You" })
            tabLayout.addTab(tabLayout.newTab().apply { text = "Watchlist" })

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when(tab?.position){
                        0 -> navController.navigate(R.id.homeFragment)
                        1 -> navController.navigate(R.id.forYouFragment)
                        else -> navController.navigate(R.id.savedFragment)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })

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