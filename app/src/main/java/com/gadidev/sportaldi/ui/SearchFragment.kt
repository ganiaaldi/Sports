package com.gadidev.sportaldi.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gadidev.sportaldi.R
import com.gadidev.sportaldi.adapter.MatchAdapter
import com.gadidev.sportaldi.databinding.FragmentSearchBinding
import com.gadidev.sportaldi.model.ListEvents
import com.gadidev.sportaldi.viewmodel.MainViewModel

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        model.isLoading.observe(viewLifecycleOwner, { isLoading ->
            binding.progressDialog.visibility = if (isLoading) View.VISIBLE else View.GONE
        })
        model.searchMatch.observe(viewLifecycleOwner, { query ->
            if(query.event == null){
                Toast.makeText(context,"Search keyword not found.",Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }else{
                binding.rvSearch.setHasFixedSize(true)
                binding.rvSearch.layoutManager = LinearLayoutManager(context)
                val adapter = MatchAdapter(query.event)
                binding.rvSearch.adapter = adapter
                adapter.setOnItemClickCallback(object : MatchAdapter.OnItemClickCallback {
                    override fun onItemClicked(events: ListEvents) {
                        model.getDetailEvents(events.idEvent)
                        model.getHomeTeams(events.idHomeTeam)
                        model.getAwayTeams(events.idAwayTeam)
                        findNavController().navigate(R.id.detailEventFragment)
                    }
                })
            }
        })
    }
}