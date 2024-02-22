package com.example.cocktails.ui.fragment

import Drink
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.cocktails.data.AppRepository
import com.example.cocktails.data.datamodels.DrinkList
import com.example.cocktails.databinding.FragmentHomeBinding
import com.example.cocktails.ui.CocktailViewModel
import com.example.cocktails.ui.adapter.HomeAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: CocktailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Holt die Liste der Drinks aus dem ViewModel
        val dataset = viewModel.drinks.value!!

        // Initialisieren von Adapter für die RecyclerView
        binding.RVhome.adapter = HomeAdapter(dataset)



        //viewModel.drinks.observe(
        //    viewLifecycleOwner
        //) {
        //    HomeAdapter(dataset).submitList(it)
        //}
    }

    //override fun onStop() {
    //    viewModel.drinks.value?.let {
    //        viewModel.updateDrinks(it)
    //    }
    //    super.onStop()
    //}
}
