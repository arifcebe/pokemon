package com.arifcebe.pokemon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arifcebe.pokemon.databinding.ActivityPokemonDetailBinding

class PokemonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}