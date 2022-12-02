package com.example.yhgg_refactoring.data.response

import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("metadata") val metadata : MetadataResponse,
    @SerializedName("info") val info : InfoResponse,
)
