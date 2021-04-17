package com.arifcebe.pokemon.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.arifcebe.pokemon.PokemonDetailActivity
import com.arifcebe.pokemon.data.model.Pokemon
import com.arifcebe.pokemon.databinding.ActivityMainBinding
import com.arifcebe.pokemon.ui.main.adapter.MainAdapter
import com.arifcebe.pokemon.ui.main.adapter.PokemonAdapterService
import com.arifcebe.pokemon.ui.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(),  PokemonAdapterService{

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf(), this)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        binding.progressBar.visibility = View.VISIBLE
        mainViewModel.getPokemons()!!.observe(this, Observer { pokemonList ->
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            renderList(pokemonList)
        })
    }

    private fun renderList(pokemons: List<Pokemon>) {
        adapter.addData(pokemons)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onClickPokemon(pokemon: Pokemon) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        startActivity(intent)
    }

}