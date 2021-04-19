package com.arifcebe.pokemon.feature.pokemon_profile.presentation.pokemon_detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifcebe.pokemon.databinding.SpritesItemBinding
import com.bumptech.glide.Glide

class SpritesAdapter(private val listOfSprites: List<String>): RecyclerView.Adapter<SpritesAdapter.SpritesViewHolder>() {
    inner class SpritesViewHolder(val binding: SpritesItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpritesViewHolder {
        val binding = SpritesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpritesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpritesViewHolder, position: Int) {
        with(holder){
            Glide.with(holder.itemView.context)
                .load(listOfSprites[position])
                .into(binding.spritesImage)
            binding.spritesName.text = if (position == 0) "Normal" else "Shiny"
        }
    }

    override fun getItemCount(): Int = listOfSprites.size
}