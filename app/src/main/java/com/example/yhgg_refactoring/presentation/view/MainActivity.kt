package com.example.yhgg_refactoring.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.yhgg_refactoring.R
import com.example.yhgg_refactoring.databinding.ActivityMainBinding
import com.example.yhgg_refactoring.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        viewModel.summonerLiveData.observe(this){ summoner ->
            startActivity(Intent(this,SummonerInfoActivity::class.java).apply {
                putExtra("summoner",summoner)
            })
        }
    }
}