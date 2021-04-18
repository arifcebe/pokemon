package com.arifcebe.pokemon.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arifcebe.pokemon.R
import com.arifcebe.pokemon.databinding.ActivityPokemonDetailBinding
import com.arifcebe.pokemon.ui.main.viewmodel.PokemonDetailViewModel
import com.google.android.material.tabs.TabLayout

class PokemonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonDetailBinding
    private lateinit var pagerAdapter: FragmentAdapter
    private lateinit var stats: StatsFragment
    private lateinit var evolution: EvolutionFragment
    private lateinit var id: String
    private lateinit var viewModel: PokemonDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pagerAdapter = FragmentAdapter(supportFragmentManager)
//        binding.viewPager.adapter = pagerAdapter
//        binding.tabLayout.setupWithViewPager(binding.viewPager)
        id = intent.getStringExtra("id").toString()
        viewModel = ViewModelProvider(this).get(PokemonDetailViewModel::class.java)
        Log.d("Debug","id or name of pokemon $id")
        viewModel.pokemonDetail(id)!!.observe(this, Observer {
            binding.pokemonName.text = it.name
        })
        stats = StatsFragment()
        evolution = EvolutionFragment()

        bindingWidgetWithAnEvent()

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Stats"),0,true)
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Evolution"),1)
    }

    private fun bindingWidgetWithAnEvent(){
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d("Debug","Position ${tab!!.position}")
                setCurrentTab(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    private fun setCurrentTab(position: Int){
        when(position){
            0 -> replaceFragment(stats)
            1 -> replaceFragment(evolution)
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment, fragment.javaClass.simpleName)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }
}