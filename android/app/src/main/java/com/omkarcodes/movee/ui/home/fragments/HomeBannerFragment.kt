package com.omkarcodes.movee.ui.home.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.omkarcodes.movee.R
import com.omkarcodes.movee.databinding.FragmentMovieBannerBinding

class HomeBannerFragment : Fragment(R.layout.fragment_movie_banner){

    private var _binding: FragmentMovieBannerBinding? = null
    private val binding: FragmentMovieBannerBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieBannerBinding.bind(view)
    }

     override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}