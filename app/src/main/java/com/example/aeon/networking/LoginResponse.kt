package com.example.aeon.networking

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success")
    val isSuccess:Boolean,
    @SerializedName("response")
    val inside: LoginResponseInside
)
data class LoginResponseInside(
        @SerializedName("token")
        val token:String
)
