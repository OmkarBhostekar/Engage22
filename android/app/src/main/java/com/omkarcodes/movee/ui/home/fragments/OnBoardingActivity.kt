package com.omkarcodes.movee.ui.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.omkarcodes.movee.R
import com.omkarcodes.movee.databinding.ActivityOnboardingBinding
import com.omkarcodes.movee.ui.MainActivity
import com.omkarcodes.movee.ui.home.adapters.GenreAdapter
import com.omkarcodes.movee.ui.home.adapters.OnboardAdapter
import com.omkarcodes.movee.ui.home.models.Genre
import com.omkarcodes.movee.utils.PrefManager

class OnBoardingActivity : AppCompatActivity(){

    lateinit var binding: ActivityOnboardingBinding

    private var currentItem = 1
    private var selectedGenres = mutableListOf<String>()
    private var isGenreShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Movee)
        val prefs = PrefManager(this)
        if (prefs.getOnBoardDone()){
            startActivity(Intent(this,MainActivity::class.java))
        }
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.apply {

            viewPager2.adapter = OnboardAdapter()
            dotIndicator.setViewPager2(viewPager2)

            viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    currentItem = position
                }
            })

            btnContinue.setOnClickListener {
                if (currentItem < 2){
                    currentItem++
                    viewPager2.currentItem = currentItem
                }else if(!isGenreShown){
                    isGenreShown = true
                    viewPager2.visibility = View.GONE
                    textView.visibility = View.VISIBLE
                    dotIndicator.visibility = View.GONE
                    rvGenre.visibility = View.VISIBLE
                    rvGenre.adapter = GenreAdapter(listOf(
                        Genre("Action"),Genre("Animation"),Genre("Fantasy"),Genre("Romance"),Genre("Comedy"),
                        Genre("Drama"),Genre("ScienceFiction"),Genre("Crime"),Genre("Adventure"),Genre("Thriller"),
                        Genre("Western"),Genre("Western"),Genre("History"),Genre("Horror"),Genre("Family"),Genre("War")
                    ),object : GenreAdapter.OnGenreClick{
                        override fun onSelect(genre: Genre) {
                            selectedGenres.add(genre.title)
                        }

                        override fun onUnselect(genre: Genre) {
                            selectedGenres.remove(genre.title)
                        }
                    })
                }else{
                    if (selectedGenres.isEmpty()){
                        Toast.makeText(
                            this@OnBoardingActivity,
                            "Please select at least on genre",
                            Toast.LENGTH_SHORT
                        ).show()
                    }else{
                        selectedGenres.forEachIndexed { index, s ->
                            if (index == 0) prefs.updateGen1(s)
                            else if (index == 1) prefs.updateGen2(s)
                            else if (index == 2) prefs.updateGen3(s)
                        }
                        prefs.setOnBoardDone()
                        startActivity(Intent(this@OnBoardingActivity,MainActivity::class.java))
                    }
                }
            }
        }

    }
}