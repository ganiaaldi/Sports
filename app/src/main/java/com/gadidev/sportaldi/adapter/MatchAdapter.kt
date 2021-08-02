package com.gadidev.sportaldi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gadidev.sportaldi.databinding.ItemMatchBinding
import com.gadidev.sportaldi.model.Events
import com.gadidev.sportaldi.model.ListEvents

class MatchAdapter(private val listData: List<ListEvents>)
    : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback
    override fun getItemCount(): Int = Math.min(listData.size, 20);

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MatchAdapter.MatchViewHolder {

        val eventsItemBinding =
                ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(eventsItemBinding)
    }


    override fun onBindViewHolder(holder: MatchAdapter.MatchViewHolder, position: Int) {
        holder.bind(listData[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listData[holder.adapterPosition]) }
    }

    inner class MatchViewHolder(private val binding: ItemMatchBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(events: ListEvents) {
            with(binding) {
                tvDateMatch.text = events.dateEvent
                tvTimeMatch.text = events.strTime
                tvVenue.text = events.strVenue
                tvMatchLeague.text = events.strLeague
                nameHome.text = events.strHomeTeam
                scoreHome.text = events.intHomeScore
                nameAway.text = events.strAwayTeam
                scoreAway.text = events.intAwayScore
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(events: ListEvents)
    }
}