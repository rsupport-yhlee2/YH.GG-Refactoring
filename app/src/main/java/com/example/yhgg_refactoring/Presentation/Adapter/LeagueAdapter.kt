package com.example.yhgg_refactoring.Presentation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yhgg_refactoring.data.response.ParticipantResponse
import com.example.yhgg_refactoring.databinding.ItemMatchBinding

class LeagueAdapter : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {
    var LeagueList = mutableListOf<ParticipantResponse>()

    inner class ViewHolder(private val binding: ItemMatchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ParticipantResponse){
            binding.matchItem = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(LeagueList[position])
    }

    override fun getItemCount(): Int {
        return LeagueList.size
    }
}