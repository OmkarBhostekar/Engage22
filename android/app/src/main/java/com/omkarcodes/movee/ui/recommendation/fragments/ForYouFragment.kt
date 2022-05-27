package com.omkarcodes.movee.ui.recommendation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.omkarcodes.movee.R
import com.omkarcodes.movee.databinding.FragmentRecommendationsBinding
import com.omkarcodes.movee.ui.recommendation.RecommendationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForYouFragment : Fragment(R.layout.fragment_recommendations){

    private var _binding: FragmentRecommendationsBinding? = null
    private val binding: FragmentRecommendationsBinding
        get() = _binding!!

    private val recommendationViewModel: RecommendationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRecommendationsBinding.bind(view)

        recommendationViewModel.getTopRated()
        recommendationViewModel.getContentBased(1)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}