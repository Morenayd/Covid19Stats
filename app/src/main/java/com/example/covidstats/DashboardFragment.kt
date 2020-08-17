package com.example.covidstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.covidstats.databinding.FragmentDashboardBinding
import com.example.covidstats.model.Result.Loading
import com.example.covidstats.model.Result.Success
import com.example.covidstats.model.Result.Failure
import com.example.covidstats.viewmodel.DashboardViewModel

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dashboard, container, false
        )
        viewModel =
            ViewModelProvider(this, App.provideViewModelFactory())[DashboardViewModel::class.java]
        viewModel.summary.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Loading -> displayToast(result.message)
                is Success -> {
                    val active = result.data.Global.TotalConfirmed - result.data.Global.TotalDeaths - result.data.Global.TotalRecovered
                    binding.confirmedCases.text = result.data.Global.TotalConfirmed.toString()
                    binding.activeCases.text = active.toString()
                    binding.recoveredCases.text = result.data.Global.TotalRecovered.toString()
                    binding.totalDeath.text = result.data.Global.TotalDeaths.toString()
                    viewModel.insertCountryStats(result.data.Countries)
                }
                is Failure -> displayToast(result.error?.localizedMessage)
            }
        })
        binding.viewAllButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_countriesStatsFragment)
        }
        return binding.root
    }

    private fun displayToast(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}