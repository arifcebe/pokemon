package com.arifcebe.pokemon.feature.pokemon_profile.presentation.pokemon_detail.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifcebe.pokemon.databinding.EvolutionItemBinding
import com.arifcebe.pokemon.feature.pokemon_profile.domain.entity.Pokemon

class EvolutionAdapter(private val list: ArrayList<Pokemon>): RecyclerView.Adapter<EvolutionAdapter.EvolutionViewHolder>() {

    inner class EvolutionViewHolder(val binding: EvolutionItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvolutionViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: EvolutionViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}