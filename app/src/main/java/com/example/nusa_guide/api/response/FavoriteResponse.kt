package com.example.nusa_guide.api.response

import com.example.nusa_guide.model.FavoritModel
import com.google.gson.annotations.SerializedName

data class FavoriteResponse (

    @SerializedName("message") val message: String,
    @SerializedName("data") val data: List<FavoritModel>

//    @field:SerializedName("data")
//    val data: List<FavoritModel?>? = null
//
//    @field:SerializedName("message")
//    val message: String? = null

)
