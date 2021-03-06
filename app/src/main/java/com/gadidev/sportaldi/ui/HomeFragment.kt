package com.gadidev.sportaldi.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gadidev.sportaldi.R
import com.gadidev.sportaldi.adapter.LeagueAdapter
import com.gadidev.sportaldi.databinding.FragmentHomeBinding
import com.gadidev.sportaldi.model.ListLeague
import com.gadidev.sportaldi.viewmodel.MainViewModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.isLoading.observe(viewLifecycleOwner, { isLoading ->
            binding.progressDialog.visibility = if (isLoading) View.VISIBLE else View.GONE
        })
        setData()
        binding.searchTeam.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(e: String): Boolean {
                val mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
                mainViewModel.searchEvents(e)
//                val args = HomeFragmentDirections.actionHomeFragmentToSearchFragment(query)
                findNavController().navigate(R.id.searchFragment)
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })
    }

    private fun setData() {
        mainViewModel.getLeague()
        mainViewModel.leagueList.observe(viewLifecycleOwner, { league ->
            binding.rvLeague.setHasFixedSize(true)
            binding.rvLeague.layoutManager = LinearLayoutManager(context)
            val adapter = LeagueAdapter(league.leagues)
            binding.rvLeague.adapter = adapter
            adapter.setOnItemClickCallback(object : LeagueAdapter.OnItemClickCallback {
                override fun onItemClicked(league: ListLeague) {
                    val mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
                    mainViewModel.getDetail(league.idLeague)
                    mainViewModel.getPrevEvents(league.idLeague)
                    mainViewModel.getNextEvents(league.idLeague)
                    findNavController().navigate(R.id.detailFragment)
                }
            })
        })
    }
}