package com.example.yhgg_refactoring.Presentation.Adapter

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yhgg_refactoring.data.response.ParticipantResponse
import com.example.yhgg_refactoring.presentation.view.MainActivity

object BindingAdapter {

    @androidx.databinding.BindingAdapter("level")
    @JvmStatic
    fun setLevel(view: TextView, level: Long) {
        view.text = level.toString()
    }

    @androidx.databinding.BindingAdapter("ImageURL")
    @JvmStatic
    fun setImage(view: ImageView, url: String) {
        Glide.with(view)
            .load(url)
            .into(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    @androidx.databinding.BindingAdapter("reItem")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: MutableList<ParticipantResponse>?) {
        if (recyclerView.adapter == null) {
            recyclerView.adapter = LeagueAdapter()
            recyclerView.layoutManager = LinearLayoutManager(MainActivity().baseContext)
        }
        val adapter = recyclerView.adapter as LeagueAdapter
        items?.let {
            adapter.LeagueList = items
        }
        adapter.notifyDataSetChanged()
    }
}