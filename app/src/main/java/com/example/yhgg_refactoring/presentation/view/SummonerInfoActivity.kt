package com.example.yhgg_refactoring.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.yhgg_refactoring.R
import com.example.yhgg_refactoring.data.DataProvider
import com.example.yhgg_refactoring.data.Key
import com.example.yhgg_refactoring.data.response.SummonerResponse
import com.example.yhgg_refactoring.databinding.ActivitySummonerInfoBinding
import com.example.yhgg_refactoring.presentation.viewModel.SummonerInfoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import yunho.app.lolapitest.lolAPI.lolAPIService

class SummonerInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummonerInfoBinding
    private val viewmodel: SummonerInfoViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_summoner_info)
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        val summoner = intent.getParcelableExtra<SummonerResponse>("summoner")
        val ret = Retrofit.Builder()
            .baseUrl(Key.MATCH_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(DataProvider.buildOkHttpClient())
            .build()
        val service = ret.create(lolAPIService::class.java)
        binding.summoner = summoner
        //소환사 랭크정보
        viewmodel.summonerLeagueLiveData.observe(this) {
            Log.e("it", "$it")
            binding.league = it
        }
        //소환사 전적정보
        viewmodel.matchDataLiveData.observe(this) {
            binding.match?.let {
                it.participants?.let {
                    binding.match?.participants = it
                }
            }
            Log.e("it", "$it")
        }
        viewmodel.getMatchIdByPuuid(summoner?.puuId!!, summoner.summonerName)
        viewmodel.searchLeagueEntryByEncryptedSummonerId(summoner?.summonerId!!)

        Log.e("summoner", "$summoner")
    }
}