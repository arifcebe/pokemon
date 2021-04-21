package com.arifcebe.pokemon.feature.pokemon_profile.presentation.pokemon_detail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arifcebe.pokemon.R
import com.arifcebe.pokemon.databinding.FragmentStatsBinding
import com.arifcebe.pokemon.feature.pokemon_profile.domain.entity.Pokemon
import com.arifcebe.pokemon.feature.pokemon_profile.domain.entity.PokemonArguments
import com.arifcebe.pokemon.feature.pokemon_profile.presentation.pokemon_detail.adapter.StatsAdapter
import com.google.gson.Gson

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_POKEMON = "pokemon"


/**
 * A simple [Fragment] subclass.
 * Use the [StatsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var pokemon: Pokemon? = null
    private var _binding: FragmentStatsBinding? = null

//    private val binding = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
//            pokemon = it.getParcelable(ARG_POKEMON)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
//        val adapter = StatsAdapter(pokemon!!)
//
//        _binding!!.recyclerView.adapter = adapter
        return _binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Stats.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, pokemon: PokemonArguments) =
            StatsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
//                    putParcelable(ARG_POKEMON, pokemon)
                }
            }
    }
}