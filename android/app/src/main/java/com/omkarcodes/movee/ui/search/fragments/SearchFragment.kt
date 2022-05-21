package com.omkarcodes.movee.ui.search.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.omkarcodes.movee.R
import com.omkarcodes.movee.comman.Constants
import com.omkarcodes.movee.databinding.FragmentSearchBinding
import com.omkarcodes.movee.databinding.ItemSearchBinding
import com.omkarcodes.movee.ui.search.SearchViewModel
import com.omkarcodes.movee.ui.search.adapters.SearchAdapter
import com.omkarcodes.movee.ui.search.models.SearchResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search), SearchAdapter.OnClickListener{

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)

        val adapter = SearchAdapter(this)
        binding.rvSearch.adapter = adapter

        binding.etSearch.addTextChangedListener {
            lifecycleScope.launch {
                viewModel.search(it.toString()).collectLatest {
                    adapter.submitData(viewLifecycleOwner.lifecycle,it)
                }
            }
        }
    }

    override fun onClick(s: SearchResult,binding: ItemSearchBinding) {
        if (s.media_type == "tv" || s.media_type == "movie"){
            val extras = FragmentNavigatorExtras(binding.ivPoster to "image_poster")
            findNavController().navigate(R.id.action_searchFragment_to_detailFragment,Bundle().apply {
                putString("posterUrl", Constants.IMAGE_URL + s.poster_path)
                putInt("id",s.id)
                putString("backdropUrl", Constants.IMAGE_URL + s.backdrop_path)
                putString("type",s.media_type)
                putString("title",if(s.media_type == "movie") s.original_title else s.name!!)
            },null,extras)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}