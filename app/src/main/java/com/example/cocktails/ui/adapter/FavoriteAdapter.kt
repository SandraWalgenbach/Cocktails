package com.example.cocktails.ui.adapter

import Drink
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktails.databinding.CocktailListBinding

class FavoriteAdapter (
    private var dataset: List<Drink>
) : RecyclerView.Adapter<FavoriteAdapter.ItemViewHolder>(){

    class ItemViewHolder(val binding: CocktailListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.ItemViewHolder {
        val binding = CocktailListBinding.inflate(LayoutInflater.from(parent.context))
        return FavoriteAdapter.ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.TVcocktailName.text = item.name
    }
}