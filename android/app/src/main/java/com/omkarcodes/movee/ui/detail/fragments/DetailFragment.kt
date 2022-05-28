package com.omkarcodes.movee.ui.detail.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.omkarcodes.movee.R
import com.omkarcodes.movee.comman.Constants.IMAGE_URL
import com.omkarcodes.movee.comman.toGenres
import com.omkarcodes.movee.databinding.FragmentDetailBinding
import com.omkarcodes.movee.databinding.ItemMovieBinding
import com.omkarcodes.movee.models.Movie
import com.omkarcodes.movee.models.Resource
import com.omkarcodes.movee.ui.MainActivity
import com.omkarcodes.movee.ui.detail.DetailViewModel
import com.omkarcodes.movee.ui.detail.adapters.CastAdapter
import com.omkarcodes.movee.ui.detail.adapters.MyRecomAdapter
import com.omkarcodes.movee.ui.detail.adapters.TmdbRecomAdapter
import com.omkarcodes.movee.ui.detail.models.video.Result
import com.omkarcodes.movee.ui.recommendation.models.RecMovie
import com.omkarcodes.movee.utils.PrefManager
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail), MyRecomAdapter.OnMovieClick, TmdbRecomAdapter.OnMovieClick{

    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding
        get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)

        if (args.type == "tv"){
            detailViewModel.getTvDetail(args.id)
            detailViewModel.getCast("tv",args.id)
            detailViewModel.getVideos("tv",args.id)
            detailViewModel.getMyRecommendation("tv",args.id)
        }else{
            detailViewModel.getMovieDetail(args.id)
            detailViewModel.getCast("movie",args.id)
            detailViewModel.getVideos("movie",args.id)
            detailViewModel.getMyRecommendation("movie",args.id)
        }

        binding.apply {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
            Glide.with(requireContext())
                    .load(args.posterUrl ?: "")
                    .into(ivPoster)
            Glide.with(requireContext()).load(args.backdropUrl)
                    .into(ivBackdrop)
            tvTitle.text = args.title
        }

        detailViewModel.apply {
            movieDetail.observe(viewLifecycleOwner) {
                if (it is Resource.Success) {
                    binding.apply {
                        it.data?.let { movie ->
                            Glide.with(requireContext())
                                .load((IMAGE_URL + movie.poster_path) ?: "")
                                .into(ivPoster)
                            Glide.with(requireContext()).load((IMAGE_URL + movie.backdrop_path))
                                .into(ivBackdrop)
                            tvTitle.text = movie.title
                            tvGenre.text = movie.genres.toGenres()
                            tvOverview.text = movie.overview
                            ratingBar.progress = (movie.vote_average).toInt()

                            btnSave.setOnClickListener {
                                detailViewModel.insertMovie(
                                    Movie(
                                        movie.id,
                                        movie.title,
                                        IMAGE_URL + movie.poster_path,
                                        IMAGE_URL + movie.backdrop_path,
                                        movie.genres.toGenres(),
                                        movie.original_language,
                                        System.currentTimeMillis()
                                    )
                                )
                            }

                        }
                    }
                }
            }
            tvDetail.observe(viewLifecycleOwner) {
                if (it is Resource.Success) {
                    binding.apply {
                        it.data?.let { tv ->
                            tvGenre.text = tv.genres.toGenres()
                            tvOverview.text = tv.overview
                            ratingBar.progress = (tv.vote_average).toInt()

                            btnSave.setOnClickListener {
                                detailViewModel.insertMovie(
                                    Movie(
                                        tv.id,
                                        tv.name,
                                        IMAGE_URL + tv.poster_path,
                                        IMAGE_URL + tv.backdrop_path,
                                        tv.genres.toGenres(),
                                        tv.original_language,
                                        System.currentTimeMillis(),
                                        "tv"
                                    )
                                )
                                Toast.makeText(context, "Added to watchlist", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
            cast.observe(viewLifecycleOwner) {
                if (it is Resource.Success) {
                    binding.cast.rvCast.adapter = CastAdapter(it.data!!)
                }
            }
            videos.observe(viewLifecycleOwner) {
                it.data?.let { data ->
                    if (data.isNotEmpty()){
                        binding.apply {
                            fabPlay.visibility = View.VISIBLE
                            fabPlay.setOnClickListener {
                                (activity as MainActivity).playVideo(data as ArrayList<Result>)
                            }
                        }
                    }
                }
            }
            recom.observe(viewLifecycleOwner){
                if (it is Resource.Success && it.data != null){
                    binding.rvRecom.adapter = MyRecomAdapter(it.data,this@DetailFragment,args.type)
                }
            }
            tmdbRecom.observe(viewLifecycleOwner){
                if (it is Resource.Success && it.data != null){
                    binding.rvRecom.adapter = TmdbRecomAdapter(it.data,this@DetailFragment,args.type)
                }
            }
        }
    }

    override fun onMyRecomClick(movie: RecMovie, type: String, binding: ItemMovieBinding) {
        val prefs = context?.let { PrefManager(it) }
        prefs?.updateIds(movie.movieId,movie.tmdbId)
        findNavController().navigate(R.id.detailFragment,Bundle().apply {
            putInt("id",movie.tmdbId)
            putString("type",args.type)
        })
    }

    override fun onTmdbRecomClick(
        movie: com.omkarcodes.movee.ui.detail.models.Result,
        type: String,
        binding: ItemMovieBinding
    ) {
        findNavController().navigate(R.id.detailFragment,Bundle().apply {
            putInt("id",movie.id)
            putString("type",args.type)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}