package com.omkarcodes.movee.ui.home.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.omkarcodes.movee.R
import com.omkarcodes.movee.comman.Constants.IMAGE_URL
import com.omkarcodes.movee.databinding.FragmentHomeBinding
import com.omkarcodes.movee.databinding.ItemBigPosterMovieBinding
import com.omkarcodes.movee.databinding.ItemMovieBinding
import com.omkarcodes.movee.models.Resource
import com.omkarcodes.movee.ui.home.HomeViewModel
import com.omkarcodes.movee.ui.home.adapters.BigPosterMoviesAdapter
import com.omkarcodes.movee.ui.home.adapters.MoviesAdapter
import com.omkarcodes.movee.ui.home.models.NetflixOg
import com.omkarcodes.movee.ui.home.models.PopularMovie
import com.omkarcodes.movee.utils.SliderTransformer
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home),MoviesAdapter.OnMovieClick,
    BigPosterMoviesAdapter.OnMovieClick {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()
    @Inject
    lateinit var name: String


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        initObservers()

        viewModel.getNetflixOriginals()
        viewModel.getPopularMovies()
//        viewModel.getNowPlayingMovies()
        viewModel.getMcuMovies()
        viewModel.getPopularTvShows()

        binding.apply {
            cardSearch.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
            }
        }

    }

    private fun initObservers() {
        viewModel.apply {
            netflixOriginals.observe(viewLifecycleOwner) {
                if (it is Resource.Success) {
                    binding.rvBigPosters.visibility = View.VISIBLE
                    binding.rvBigPosters.apply{
                        adapter = BigPosterMoviesAdapter(it.data!!, this@HomeFragment)
                        offscreenPageLimit = 3
                        setPageTransformer(SliderTransformer(3))
                    }
                }
            }
            popularMovies.observe(viewLifecycleOwner) {
                if (it is Resource.Success) {
                    binding.tvHeadline2.visibility = View.VISIBLE
                    binding.rvPopularMovies.visibility = View.VISIBLE
                    binding.rvPopularMovies.adapter =
                        MoviesAdapter(it.data!!, this@HomeFragment, "movie")
                }
            }
            popularTvShows.observe(viewLifecycleOwner) {
                if (it is Resource.Success) {
                    binding.tvHeadline3.visibility = View.VISIBLE
                    binding.rvTvShows.visibility = View.VISIBLE
                    binding.rvTvShows.adapter = MoviesAdapter(it.data!!, this@HomeFragment, "tv")
                }
            }
            mcuMovies.observe(viewLifecycleOwner) {
                if (it is Resource.Success) {
                    binding.tvHeadline5.visibility = View.VISIBLE
                    binding.rvMcuMovies.visibility = View.VISIBLE
                    binding.rvMcuMovies.adapter =
                        MoviesAdapter(it.data!!, this@HomeFragment, "movie")
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onBigPosterClick(movie: NetflixOg, binding: ItemBigPosterMovieBinding) {
        val extras = FragmentNavigatorExtras(binding.ivPoster to "image_poster")
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment,Bundle().apply {
            putString("posterUrl",IMAGE_URL + movie.poster_path)
            putInt("id",movie.id)
            putString("backdropUrl", IMAGE_URL + movie.backdrop_path)
            putString("type","tv")
            putString("title",movie.name)
        },null,extras)
    }

    override fun onClick(movie: PopularMovie, type: String, binding: ItemMovieBinding) {
        val extras = FragmentNavigatorExtras(binding.ivPoster to "image_poster")
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment,Bundle().apply {
            putString("posterUrl",IMAGE_URL + movie.poster_path)
            putInt("id",movie.id)
            putString("backdropUrl", IMAGE_URL + movie.backdrop_path)
            putString("type",type)
            putString("title",movie.title)
        },null,extras)
    }
}