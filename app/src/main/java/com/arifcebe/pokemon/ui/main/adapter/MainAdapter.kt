package com.arifcebe.pokemon.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifcebe.pokemon.R
import com.arifcebe.pokemon.data.model.Pokemon
import com.arifcebe.pokemon.databinding.PokemonItemBinding
import com.arifcebe.pokemon.utils.MappingClass
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.pokemon_item.view.*

class MainAdapter(private val pokemons: ArrayList<Pokemon>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    /*class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pokemon: Pokemon) {

            val id = MappingClass.getIdByUrl(pokemon.url!!)
            val imageUrl = MappingClass.generateProfileImageUrl(id)

            itemView.pokemon_name.text = pokemon.name
            itemView.pokemon_id.text = MappingClass.generateIdLabel(id)
            Glide.with(itemView.context)
                .load(imageUrl)
                .into(itemView.pokemon_picture)

        }
    }*/

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
//        DataViewHolder(
//            LayoutInflater.from(parent.context).inflate(
//                R.layout.pokemon_item, parent, false
//            )
//        )



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
            }
        }
    }

    inner class DataViewHolder(val binding: PokemonItemBinding): RecyclerView.ViewHolder(binding.root)


    override fun getItemCount(): Int = pokemons.size

    fun addData(list: List<Pokemon>) {
        pokemons.addAll(list)
    }
}