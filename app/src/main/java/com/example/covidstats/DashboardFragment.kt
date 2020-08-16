package com.example.covidstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.covidstats.databinding.FragmentDashboardBinding
import com.example.covidstats.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dashboard, container,false)

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        getStatusSummary()
        val confirmed = viewModel.summary.global.totalConfirmed
        val totalDeaths = viewModel.summary.global.totalDeaths
        val recovered = viewModel.summary.global.totalRecovered
        val active = confirmed - totalDeaths - recovered
        confirmed_cases.text = confirmed.toString()
        active_cases.text = active.toString()
        recovered_cases.text = recovered.toString()
        total_death.text = totalDeaths.toString()

        return binding.root
    }

    private fun getStatusSummary() {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getStatusSummary()
        }
    }
}