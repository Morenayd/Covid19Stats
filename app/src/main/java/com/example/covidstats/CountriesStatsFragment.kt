package com.example.covidstats

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CountriesStatsAdapter()
        binding.statList.addItemDecoration(MarginItemDecoration(16))
        viewModel.countries.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        binding.statList.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        val searchMenu = menu.findItem(R.id.action_search)
        val searchView = searchMenu.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.getSearchResults(newText)
                return false
            }
        })
    }
}