package com.gadidev.sportaldi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gadidev.sportaldi.databinding.ItemLeagueBinding
import com.gadidev.sportaldi.model.League
import com.gadidev.sportaldi.model.ListLeague

class LeagueAdapter(private val listData: List<ListLeague>)
    : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback
    override fun getItemCount(): Int = Math.min(listData.size, 20);

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LeagueAdapter.LeagueViewHolder {

        val leagueItemBinding =
            ItemLeagueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LeagueViewHolder(leagueItemBinding)
    }


    override fun onBindViewHolder(holder: LeagueAdapter.LeagueViewHolder, position: Int) {
        holder.bind(listData[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listData[holder.adapterPosition]) }
    }

    inner class LeagueViewHolder(private val binding: ItemLeagueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(league: ListLeague) {
            with(binding) {
                tvNameLeague.text = league.strLeague
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(league: ListLeague)
    }
}