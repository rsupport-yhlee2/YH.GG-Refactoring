package com.example.yhgg_refactoring.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.yhgg_refactoring.R
import com.example.yhgg_refactoring.data.response.SummonerResponse
import com.example.yhgg_refactoring.databinding.ActivitySummonerInfoBinding
import com.example.yhgg_refactoring.presentation.viewModel.SummonerInfoViewModel
import io.reactivex.schedulers.Schedulers
import org.koin.androidx.viewmodel.ext.android.viewModel

class SummonerInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummonerInfoBinding
    private val viewmodel: SummonerInfoViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_summoner_info)
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        val summoner = intent.getParcelableExtra<SummonerResponse>("summoner")
        binding.summoner = summoner
        //소환사 랭크정보
        viewmodel.summonerLeagueLiveData.observe(this) {
            Log.e("it", "$it")
        }
        //소환사 전적정보
        viewmodel.matchDataLiveData.observe(this) {

        }
        //viewmodel.getMatchIdByPuuid(summoner?.puuId!!, summoner.summonerName)
        viewmodel.searchLeagueEntryByEncryptedSummonerId(summoner?.summonerId!!)

        Log.e("summoner", "$summoner")
    }
}