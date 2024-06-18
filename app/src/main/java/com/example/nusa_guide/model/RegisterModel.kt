package com.example.nusa_guide.model

import com.google.gson.annotations.SerializedName

data class RegisterModel(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
