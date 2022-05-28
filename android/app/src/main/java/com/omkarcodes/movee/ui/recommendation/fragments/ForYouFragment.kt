package com.omkarcodes.movee.ui.recommendation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.omkarcodes.movee.R
import com.omkarcodes.movee.databinding.FragmentRecommendationsBinding
import com.omkarcodes.movee.databinding.ItemBigPosterMovieBinding
import com.omkarcodes.movee.databinding.ItemMovieBinding
import com.omkarcodes.movee.models.Resource
import com.omkarcodes.movee.ui.detail.adapters.MyRecomAdapter
import com.omkarcodes.movee.ui.home.adapters.BigPosterMoviesAdapter
import com.omkarcodes.movee.ui.recommendation.RecommendationViewModel
import com.omkarcodes.movee.ui.recommendation.adapters.TopCarouselAdapter
import com.omkarcodes.movee.ui.recommendation.models.RecMovie
import com.omkarcodes.movee.utils.PrefManager
import com.omkarcodes.movee.utils.SliderTransformer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForYouFragment : Fragment(R.layout.fragment_recommendations), TopCarouselAdapter.OnMovieClick,
MyRecomAdapter.OnMovieClick{

    private var _binding: FragmentRecommendationsBinding? = null
    private val binding: FragmentRecommendationsBinding
        get() = _binding!!

    private val recommendationViewModel: RecommendationViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRecommendationsBinding.bind(view)

        binding.apply {

            rvBigPosters.apply{
                offscreenPageLimit = 3
                setPageTransformer(SliderTransformer(3))
            }

            val prefs = PrefManager(requireContext())

            recommendationViewModel.apply {
                val g1 = prefs.getGen1()
                val g2 = prefs.getGen2()
                val g3 = prefs.getGen3()
                getTopRated()
                getContentBased(prefs.getRecentTmdbId())
                getCFRecom(prefs.getRecentMovieId())
                getGen1(g1)
                getGen2(g2)
                getGen3(g3)

                topRated.observe(viewLifecycleOwner) {
                    when(it){
                        is Resource.Success -> {
                            binding.rvBigPosters.visibility = View.VISIBLE
                            binding.rvBigPosters.adapter = TopCarouselAdapter(it.data!!,this@ForYouFragment)
                        }
                        else -> Unit
                    }
                }

                contentBased.observe(viewLifecycleOwner) {
                    when(it){
                        is Resource.Success -> {
                            binding.tvHeadline.visibility = View.VISIBLE
                            binding.rvRecom.visibility = View.VISIBLE
                            binding.rvRecom.adapter = MyRecomAdapter(it.data!!,this@ForYouFragment,"movie")
                        }
                        else -> Unit
                    }
                }

                cfBased.observe(viewLifecycleOwner) {
                    when(it){
                        is Resource.Success -> {
                            binding.tvHeadline2.visibility = View.VISIBLE
                            binding.rvCfRecom.visibility = View.VISIBLE
                            binding.rvCfRecom.adapter = MyRecomAdapter(it.data!!,this@ForYouFragment,"movie")
                        }
                        else -> Unit
                    }
                }

                gen1.observe(viewLifecycleOwner) {
                    when(it){
                        is Resource.Success -> {
                            binding.tvGenre1.text = "$g1 Movies"
                            binding.tvGenre1.visibility = View.VISIBLE
                            binding.rvGenre1.visibility = View.VISIBLE
                            binding.rvGenre1.adapter = MyRecomAdapter(it.data!!,this@ForYouFragment,"movie")
                        }
                        else -> Unit
                    }
                }

                gen2.observe(viewLifecycleOwner) {
                    when(it){
                        is Resource.Success -> {
                            binding.tvGenre2.text = "$g2 Movies"
                            binding.tvGenre2.visibility = View.VISIBLE
                            binding.rvGenre2.visibility = View.VISIBLE
                            binding.rvGenre2.adapter = MyRecomAdapter(it.data!!,this@ForYouFragment,"movie")
                        }
                        else -> Unit
                    }
                }

                gen3.observe(viewLifecycleOwner) {
                    when(it){
                        is Resource.Success -> {
                            binding.tvGenre3.text = "$g3 Movies"
                            binding.tvGenre3.visibility = View.VISIBLE
                            binding.rvGenre3.visibility = View.VISIBLE
                            binding.rvGenre3.adapter = MyRecomAdapter(it.data!!,this@ForYouFragment,"movie")
                        }
                        else -> Unit
                    }
                }
            }
        }

    }

    override fun onCarouselClick(movie: RecMovie, binding: ItemBigPosterMovieBinding) {
        val prefs = context?.let { PrefManager(it) }
        prefs?.updateIds(movie.movieId,movie.tmdbId)
        findNavController().navigate(ForYouFragmentDirections.actionForYouFragmentToDetailFragment(id = movie.tmdbId, type = "movie"))
    }

    override fun onMyRecomClick(movie: RecMovie, type: String, binding: ItemMovieBinding) {
        val prefs = context?.let { PrefManager(it) }
        prefs?.updateIds(movie.movieId,movie.tmdbId)
        findNavController().navigate(ForYouFragmentDirections.actionForYouFragmentToDetailFragment(id = movie.tmdbId, type = type))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}