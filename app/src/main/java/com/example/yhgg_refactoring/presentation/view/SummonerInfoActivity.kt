package com.example.yhgg_refactoring.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.yhgg_refactoring.R
import com.example.yhgg_refactoring.data.response.SummonerResponse

class SummonerInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val summoner = intent.getParcelableExtra<SummonerResponse>("summoner")
        setContentView(R.layout.activity_summoner_info)
        Log.e("summoner","$summoner")
    }
}