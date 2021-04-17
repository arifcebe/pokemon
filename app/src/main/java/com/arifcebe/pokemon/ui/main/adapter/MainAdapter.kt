package com.arifcebe.pokemon.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifcebe.pokemon.R
import com.arifcebe.pokemon.data.model.Pokemon
import com.arifcebe.pokemon.databinding.PokemonItemBinding
import com.arifcebe.pokemon.utils.MappingClass
import com.bumptech.glide.Glide

interface PokemonAdapterService {
    fun onClickPokemon(pokemon: Pokemon)
}

class MainAdapter(private val pokemons: ArrayList<Pokemon>, private val pokemonService: PokemonAdapterService) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    var selectedItem: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        with(holder){
            val pokemon = pokemons[position]
            with(pokemon){
                val id = MappingClass.getIdByUrl(pokemon.url!!)
                val imageUrl = MappingClass.generateProfileImageUrl(id)

                binding.pokemonName.text = pokemon.name
                binding.pokemonId.text = MappingClass.generateIdLabel(id)
                Glide.with(holder.itemView.context)
                    .load(imageUrl)
                    .into(binding.pokemonPicture)

                holder.itemView.setOnClickListener {
                    pokemonService.onClickPokemon(pokemon)
                }

            }
        }
    }

    inner class DataViewHolder(val binding: PokemonItemBinding): RecyclerView.ViewHolder(binding.root)


    override fun getItemCount(): Int = pokemons.size

    fun addData(list: List<Pokemon>) {
        pokemons.addAll(list)
    }
}