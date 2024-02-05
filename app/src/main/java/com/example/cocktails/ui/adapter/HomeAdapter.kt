package com.example.cocktails.ui.adapter

import Drink
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.cocktails.databinding.CocktailListBinding

class HomeAdapter (
    private var dataset: List<Drink>
) : RecyclerView.Adapter<HomeAdapter.ItemViewHolder>(){

    class ItemViewHolder(val binding: CocktailListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ItemViewHolder {
        val binding = CocktailListBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]
        //val context = holder.binding.root.context
        val text = holder.binding.TVcocktailName
        val image = holder.binding.IVCocktailPic

        text.text = item.name

        image.load(item.picture)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}