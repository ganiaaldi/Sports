package com.gadidev.sportaldi.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gadidev.sportaldi.R
import com.gadidev.sportaldi.adapter.LeagueAdapter
import com.gadidev.sportaldi.adapter.MatchAdapter
import com.gadidev.sportaldi.databinding.FragmentPrevEventBinding
import com.gadidev.sportaldi.model.ListEvents
import com.gadidev.sportaldi.model.ListLeague
import com.gadidev.sportaldi.viewmodel.MainViewModel


class PrevEventFragment : Fragment() {
    private var _binding: FragmentPrevEventBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPrevEventBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        model.prevEvent.observe(viewLifecycleOwner, { events ->
            Log.d("apakah","${events}")
            binding.rvPrev.setHasFixedSize(true)
            binding.rvPrev.layoutManager = LinearLayoutManager(context)
            val adapter = MatchAdapter(events.events)
            binding.rvPrev.adapter = adapter
            adapter.setOnItemClickCallback(object : MatchAdapter.OnItemClickCallback {
                override fun onItemClicked(events: ListEvents) {
//                    findNavController().navigate(
////                            HomeFragmentDirections.actionHomeFragmentToDetailFragment(
////                                    league.idLeague
//                            )
//                    )
                    model.getDetailEvents(events.idEvent)
                    model.getHomeTeams(events.idHomeTeam)
                    model.getAwayTeams(events.idAwayTeam)
                    findNavController().navigate(R.id.detailEventFragment)
                }
            })
        })
    }
    }
