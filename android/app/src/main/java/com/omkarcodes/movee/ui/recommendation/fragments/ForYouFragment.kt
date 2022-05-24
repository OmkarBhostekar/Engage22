package com.omkarcodes.movee.ui.recommendation

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.omkarcodes.movee.R
import com.omkarcodes.movee.databinding.FragmentRecommendationsBinding
import com.omkarcodes.movee.databinding.FragmentSavedBinding
import com.omkarcodes.movee.databinding.ItemSearchBinding
import com.omkarcodes.movee.models.Movie
import com.omkarcodes.movee.ui.saved.SavedViewModel
import com.omkarcodes.movee.ui.saved.adapters.SavedAdapter
import com.omkarcodes.movee.ui.saved.fragments.SavedFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForYouFragment : Fragment(R.layout.fragment_recommendations){

    private var _binding: FragmentRecommendationsBinding? = null
    private val binding: FragmentRecommendationsBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRecommendationsBinding.bind(view)



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}