package com.example.cocktails.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktails.data.datamodels.Cocktail
import com.example.cocktails.databinding.CocktailListBinding
import com.example.cocktails.databinding.ProfilListBinding

class ProfilAdapter (
    private var dataset: List<Cocktail>
) : RecyclerView.Adapter<ProfilAdapter.ItemViewHolder>(){

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Cocktail>) {
        dataset = list
        notifyDataSetChanged()
    }

    class ItemViewHolder(val binding: ProfilListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilAdapter.ItemViewHolder {
        val binding = ProfilListBinding.inflate(LayoutInflater.from(parent.context))
        return ProfilAdapter.ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfilAdapter.ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.TVcocktailNameProfil.text = item.name

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}