package com.omkarcodes.movee.ui.saved.fragments

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.omkarcodes.movee.R
import com.omkarcodes.movee.databinding.FragmentSavedBinding
import com.omkarcodes.movee.databinding.ItemSearchBinding
import com.omkarcodes.movee.models.Movie
import com.omkarcodes.movee.ui.saved.SavedViewModel
import com.omkarcodes.movee.ui.saved.adapters.SavedAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedFragment : Fragment(R.layout.fragment_saved), SavedAdapter.OnClickListener{

    private var _binding: FragmentSavedBinding? = null
    private val binding: FragmentSavedBinding
        get() = _binding!!

    private val savedViewModel: SavedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSavedBinding.bind(view)

        savedViewModel.getSaved().observe(viewLifecycleOwner) {
            binding.rvSaved.adapter = SavedAdapter(this, it)
            val swipeListener = object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return true
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    savedViewModel.deleteMovie(it[viewHolder.adapterPosition])
                }
            }
            val itemTouchHelper = ItemTouchHelper(swipeListener)
            itemTouchHelper.attachToRecyclerView(binding.rvSaved)
        }

    }

    override fun onClick(s: Movie, binding: ItemSearchBinding) {
        findNavController().navigate(SavedFragmentDirections.actionSavedFragmentToDetailFragment(s.posterUrl,s.id,s.type,s.title,s.backdropUrl))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}