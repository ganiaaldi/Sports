package com.gadidev.sportaldi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gadidev.sportaldi.databinding.FragmentDetailEventBinding
import com.gadidev.sportaldi.viewmodel.MainViewModel


class DetailEventFragment : Fragment() {
    private var _binding: FragmentDetailEventBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailEventBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    private fun setData() {
        binding.imgBack.setOnClickListener { findNavController().navigateUp() }
        val model = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        model.isLoading.observe(viewLifecycleOwner, { isLoading ->
            binding.progressDialog.visibility = if (isLoading) View.VISIBLE else View.GONE
        })
        model.detailEvent.observe(viewLifecycleOwner, { events ->
            binding.tvDesc.text = events.events[0].strDescriptionEN
            binding.tvDateMatch.text = events.events[0].dateEvent
            binding.tvTimeMatch.text = events.events[0].strTime
            binding.tvVenue.text = events.events[0].strVenue
            binding.tvMatchLeague.text = events.events[0].strLeague
            binding.tvHomeScore.text = events.events[0].intHomeScore
            binding.tvAwayScore.text = events.events[0].intAwayScore
            binding.tvHomeName.text = events.events[0].strHomeTeam
            binding.tvAwayName.text = events.events[0].strAwayTeam
            binding.shotsHome.text = events.events[0].intHomeShots
            binding.shotsAway.text = events.events[0].intAwayShots
            binding.formationHome.text = events.events[0].strHomeFormation
            binding.formationAway.text = events.events[0].strAwayFormation
            binding.yellowCardHome.text = events.events[0].strHomeYellowCards
            binding.yellowCardAway.text = events.events[0].strAwayYellowCards
            binding.redCardHome.text = events.events[0].strHomeRedCards
            binding.redCardAway.text = events.events[0].strAwayRedCards
            binding.goalDetailsHome.text = events.events[0].strHomeGoalDetails
            binding.goalDetailsAway.text = events.events[0].strAwayGoalDetails
        })
        model.homeTeams.observe(viewLifecycleOwner, { teams ->
            Glide.with(requireContext())
                    .load(teams.teams[0].strTeamBadge)
                    .apply(RequestOptions())
                    .into(binding.imgHome)
        })
        model.awayTeams.observe(viewLifecycleOwner, { teams ->
            Glide.with(requireContext())
                    .load(teams.teams[0].strTeamBadge)
                    .apply(RequestOptions())
                    .into(binding.imgAway)
        })
    }
}