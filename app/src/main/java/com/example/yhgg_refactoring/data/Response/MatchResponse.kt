package com.example.yhgg_refactoring.Data.Response

import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("metadata") val metadata : MetadataResponse,
    @SerializedName("info") val info : InfoResponse,
)
