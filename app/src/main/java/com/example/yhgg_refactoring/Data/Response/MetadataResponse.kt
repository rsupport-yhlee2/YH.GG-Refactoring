package com.example.yhgg_refactoring.Data.Response

import com.google.gson.annotations.SerializedName

data class MetadataResponse (
    @SerializedName("dataVersion") val dataVersion : String,
    @SerializedName("matchId") val matchId : String,
    @SerializedName("participants") val participants : List<String>
        )