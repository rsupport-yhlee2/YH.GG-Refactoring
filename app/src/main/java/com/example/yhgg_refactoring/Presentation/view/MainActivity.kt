package com.example.yhgg_refactoring.Presentation.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.yhgg_refactoring.Data.Response.Data.Response.R
import com.example.yhgg_refactoring.Data.Response.SummonerResponse
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import yunho.app.lolapitest.lolAPI.lolAPIService
import java.security.Key

class MainActivity : AppCompatActivity() {
    private val firebase by lazy { Firebase.database }
    private val ref by lazy { firebase.reference }
    private lateinit var key: String
    private lateinit var lolAPI: lolAPIService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                key = snapshot.child("api_key").value.toString()
                Log.e("key:", key)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        val retrofit = Retrofit.Builder()
            .baseUrl("https://kr.api.riotgames.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        lolAPI = retrofit.create(lolAPIService::class.java)
        Handler().postDelayed({
            lolAPI.getSummonerInfoByName("LYH123", key).enqueue(object : Callback<SummonerResponse> {
                override fun onResponse(
                    call: Call<SummonerResponse>,
                    response: Response<SummonerResponse>
                ) {
                    if (!response.isSuccessful) {
                        return
                    }
                    response.body().let {
                        Log.e("summoner", it.toString())
                    }
                }

                override fun onFailure(call: Call<SummonerResponse>, t: Throwable) {

                }

            })
        },1000)
    }
}