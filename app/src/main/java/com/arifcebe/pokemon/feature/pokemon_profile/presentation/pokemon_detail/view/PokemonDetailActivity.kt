package com.arifcebe.pokemon.feature.pokemon_profile.presentation.pokemon_detail.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arifcebe.pokemon.R
import com.arifcebe.pokemon.databinding.ActivityPokemonDetailBinding
import com.arifcebe.pokemon.feature.pokemon_profile.domain.entity.PokemonArguments
import com.arifcebe.pokemon.feature.pokemon_profile.domain.entity.PokemonSpecies
import com.arifcebe.pokemon.feature.pokemon_profile.domain.entity.PokemonSpeciesArguments
import com.arifcebe.pokemon.feature.pokemon_profile.domain.entity.StatArguments
import com.arifcebe.pokemon.feature.pokemon_profile.presentation.pokemon_detail.viewmodel.PokemonDetailViewModel
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout

class PokemonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailBinding
    private lateinit var statsFragment: StatsFragment
    private lateinit var evolutionFragment: EvolutionFragment
    private lateinit var id: String
    private lateinit var viewModel: PokemonDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.getStringExtra("id").toString()

        viewModel = ViewModelProvider(this).get(PokemonDetailViewModel::class.java)
        var pokemonArguments: PokemonArguments? = null
        binding.pokemonName.text = id

        loadingProgress(true)
        viewModel.pokemonDetail(this, id)!!.observe(this, Observer {
            loadingProgress(false)
            Glide.with(applicationContext)
                .load(it.image)
                .into(binding.pokemonPicture)
            binding.pokemonType.text = it.type
            binding.pokemonDescription.text = it.species.flavorTextEntry

            val stats: List<StatArguments> = it.stats.map { s -> StatArguments(s.baseStat, s.effort, s.statName) }.toList()
            val species: PokemonSpecies = it.pokemonSpecies
            val speciesArgs: PokemonSpeciesArguments = PokemonSpeciesArguments(species.baseHappiness, species.captureRate, species.color, species.flavorTextEntry)
            pokemonArguments = PokemonArguments(it.id,it.name,it.idLabel,speciesArgs,it.abilities,stats,it.image,it.type,it.sprites)

            statsFragment = StatsFragment.newInstance("0","2", pokemonArguments!!)
            evolutionFragment = EvolutionFragment()

            bindingWidgetWithAnEvent()
        })
//
//        statsFragment = StatsFragment()
//        evolutionFragment = EvolutionFragment()
//
//        bindingWidgetWithAnEvent()

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Stats"),0,true)
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Evolution"),1)
    }

    private fun loadingProgress(isLoading: Boolean){
        binding.progressBar.isVisible = isLoading
        binding.appbarLayout.isVisible = !isLoading
        binding.nestedScrollview.isVisible = !isLoading
    }

    private fun bindingWidgetWithAnEvent(){
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d("Debug","Position ${tab!!.position}")
                setCurrentTab(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    private fun setCurrentTab(position: Int){
        when(position){
            0 -> replaceFragment(statsFragment)
            1 -> replaceFragment(evolutionFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment, fragment.javaClass.simpleName)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }


}