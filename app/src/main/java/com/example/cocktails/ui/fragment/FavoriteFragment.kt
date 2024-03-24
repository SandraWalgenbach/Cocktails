package com.example.cocktails.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cocktails.databinding.FragmentFavoriteBinding
import com.example.cocktails.ui.CocktailViewModel
import com.example.cocktails.ui.adapter.HomeAdapter

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val viewModel: CocktailViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Holt die Liste der Drinks aus dem ViewModel
        //val dataset = viewModel.drinks.value!!

        // Initialisieren von Adapter für die RecyclerView
        //binding.RVfavorite.adapter = HomeAdapter(dataset)

    }
}