package com.example.cocktails.ui.adapter

import Drink
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.cocktails.R
import com.example.cocktails.data.datamodels.DrinkList
import com.example.cocktails.databinding.CocktailListBinding
import com.example.cocktails.ui.fragment.HomeFragmentDirections

class HomeAdapter (
    private var dataset: List<Drink>
) : RecyclerView.Adapter<HomeAdapter.ItemViewHolder>(){

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Drink>) {
        dataset = list
        notifyDataSetChanged()
    }

    class ItemViewHolder(val binding: CocktailListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = CocktailListBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        //holder.binding.TVcocktailName.text = item.name
        //holder.binding.IVCocktailPic.load(item.picture)

        //Click Listeners, Navigiert zu DetailFragment durch klick auf die card
        holder.binding.CVcocktail.setOnClickListener {

            val navController = holder.itemView.findNavController()
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(position))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}