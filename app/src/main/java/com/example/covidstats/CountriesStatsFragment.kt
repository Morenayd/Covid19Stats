package com.example.covidstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidstats.databinding.FragmentCountriesStatsBinding
import com.example.covidstats.viewmodel.DashboardViewModel

class CountriesStatsFragment : Fragment() {
    private lateinit var binding: FragmentCountriesStatsBinding
    private val viewModel: DashboardViewModel by lazy {
        ViewModelProvider(this, App.provideViewModelFactory())[DashboardViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_countries_stats, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CountriesStatsAdapter()
        viewModel.countryStats.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        binding.statList.layoutManager = LinearLayoutManager(activity)
        binding.statList.adapter = adapter
    }
}