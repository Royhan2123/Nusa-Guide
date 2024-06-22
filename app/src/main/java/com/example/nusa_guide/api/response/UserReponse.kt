package com.example.nusa_guide.api.response

import com.example.nusa_guide.model.UserModel
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: List<UserModel>
)