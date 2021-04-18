package com.arifcebe.pokemon.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arifcebe.pokemon.data.entity.PokemonEntity
import com.arifcebe.pokemon.data.model.PokemonList
import com.arifcebe.pokemon.data.room_model.PokemonRoomModel
import com.arifcebe.pokemon.databinding.ActivityMainBinding
import com.arifcebe.pokemon.ui.main.adapter.MainAdapter
import com.arifcebe.pokemon.ui.main.adapter.PokemonAdapterService
import com.arifcebe.pokemon.ui.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(),  PokemonAdapterService{

    private var isLoading: Boolean = false
    private var page: Int = 0
    private val limit: Int = 20
    private var offset: String = "0"
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = MainAdapter(arrayListOf(), this)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                val total = adapter.itemCount

                Log.d("Debug","visible item $visibleItemCount $pastVisibleItem $total")
                if (!isLoading) {

                    if ((visibleItemCount + pastVisibleItem) >= total) {
                        page++
                        setupObserver()
                    }

                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun setupObserver() {
        binding.progressBar.visibility = View.VISIBLE
        isLoading = true
        val start = ((page) * limit) + 1
        val end = (page + 1) * limit
        mainViewModel.getPokemons(applicationContext, offset)!!.observe(this, Observer { pokemonList ->
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            isLoading = false
            offset = pokemonList.last().id
            renderList(pokemonList)
        })
    }

    private fun renderList(pokemons: List<PokemonEntity>) {
        adapter.addData(pokemons)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onClickPokemon(pokemon: PokemonEntity) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        intent.putExtra("id", pokemon.name)
        startActivity(intent)
    }

}