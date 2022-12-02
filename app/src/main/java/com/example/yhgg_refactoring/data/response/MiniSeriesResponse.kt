package com.example.yhgg_refactoring.data.response

import com.google.gson.annotations.SerializedName

data class MiniSeriesResponse(
    @SerializedName("losses") val losses : Int,
    @SerializedName("progress") val progress : String,
    @SerializedName("target") val target : Int,
    @SerializedName("wins") val wins : Int,

)
