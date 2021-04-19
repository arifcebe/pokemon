package com.arifcebe.pokemon.feature.pokemon_profile.presentation.pokemon_detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifcebe.pokemon.databinding.SpritesItemBinding
import com.arifcebe.pokemon.databinding.StatsItemBinding
import com.arifcebe.pokemon.feature.pokemon_profile.domain.entity.Pokemon
import com.bumptech.glide.Glide
import okhttp3.internal.applyConnectionSpec
import java.lang.IllegalArgumentException

abstract class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    //abstract fun bind(item: T)
}


class StatsAdapter(val pokemon: Pokemon): RecyclerView.Adapter<BaseViewHolder>() {

    companion object {
        private const val STATS = 0
        private const val ABILITY = 1
        private const val SPRITES = 2
    }

    inner class SpritesViewHolder(val binding: SpritesItemBinding): BaseViewHolder(binding.root)
    inner class StatsPokemonHolder(val binding: StatsItemBinding): BaseViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            STATS -> {
                val binding = StatsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                StatsPokemonHolder(binding)
            }
            SPRITES -> {
                val binding = SpritesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SpritesViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is StatsPokemonHolder -> {
                val stats = pokemon.stats[position]
                holder.binding.statsName.text = stats.statName
                holder.binding.statsValue.text = stats.baseStat.toString()
            }
            is SpritesViewHolder -> {
                holder.binding.spritesName.text = if (position == 0) "Normal" else "Shiny"
                Glide.with(holder.itemView.context)
                    .load(pokemon.sprites[position])
                    .into(holder.binding.spritesImage)
            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (position){
            0 -> STATS
            1 -> ABILITY
            2 -> SPRITES
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }


}

