package com.gadidev.sportaldi.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gadidev.sportaldi.adapter.ViewPagerAdapter
import com.gadidev.sportaldi.databinding.FragmentDetailBinding
import com.gadidev.sportaldi.viewmodel.MainViewModel


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        createPager()
    }

    private fun setData() {
        val model = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        model.isLoading.observe(viewLifecycleOwner, { isLoading ->
            binding.progressDialog.visibility = if (isLoading) View.VISIBLE else View.GONE
        })
        model.leagueDetail.observe(viewLifecycleOwner, { league ->
            binding.tvTitle.text = league.leagues[0].strLeague
            binding.tvCurrentSeason.text = league.leagues[0].strCurrentSeason
            binding.tvWebsite.text = league.leagues[0].strWebsite
            Glide.with(requireContext())
                .load(league.leagues[0].strBadge)
                .apply(RequestOptions())
                .into(binding.imgLeagueDetail)
        })
//    })
    }

    fun createPager(){
        val pagerAdapter = ViewPagerAdapter(childFragmentManager)
       binding.destinationViewPager.adapter = pagerAdapter
        binding.destinationTabLayout.setupWithViewPager(binding.destinationViewPager)
    }

}