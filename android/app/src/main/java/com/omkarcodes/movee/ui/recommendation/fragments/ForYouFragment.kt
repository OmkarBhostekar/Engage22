package com.omkarcodes.movee.ui.recommendation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.omkarcodes.movee.R
import com.omkarcodes.movee.databinding.FragmentRecommendationsBinding
import com.omkarcodes.movee.databinding.ItemBigPosterMovieBinding
import com.omkarcodes.movee.models.Resource
import com.omkarcodes.movee.ui.home.adapters.BigPosterMoviesAdapter
import com.omkarcodes.movee.ui.recommendation.RecommendationViewModel
import com.omkarcodes.movee.ui.recommendation.adapters.TopCarouselAdapter
import com.omkarcodes.movee.ui.recommendation.models.RecMovie
import com.omkarcodes.movee.utils.SliderTransformer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForYouFragment : Fragment(R.layout.fragment_recommendations), TopCarouselAdapter.OnMovieClick{

    private var _binding: FragmentRecommendationsBinding? = null
    private val binding: FragmentRecommendationsBinding
        get() = _binding!!

    private val recommendationViewModel: RecommendationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRecommendationsBinding.bind(view)

        binding.apply {

            rvBigPosters.apply{
                offscreenPageLimit = 3
                setPageTransformer(SliderTransformer(3))
            }

        }

        recommendationViewModel.apply {
            getTopRated()
            getContentBased(1)

            topRated.observe(viewLifecycleOwner) {
                when(it){
                    is Resource.Success -> {
                        binding.rvBigPosters.adapter = TopCarouselAdapter(it.data!!,this@ForYouFragment)
                    }
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {

                    }
                    else -> Unit
                }
            }
        }

    }

    override fun onCarouselClick(movie: RecMovie, binding: ItemBigPosterMovieBinding) {
        findNavController().navigate(ForYouFragmentDirections.actionForYouFragmentToDetailFragment(id = 260, type = "movie"))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}