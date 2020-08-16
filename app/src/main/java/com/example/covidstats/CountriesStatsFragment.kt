package com.example.covidstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidstats.databinding.FragmentCountriesStatsBinding

class CountriesStatsFragment : Fragment() {
    private lateinit var binding: FragmentCountriesStatsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_countries_stats, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CountriesStatsAdapter(listOf())
        binding.statList.layoutManager = LinearLayoutManager(activity)
        binding.statList.adapter = adapter
    }
}