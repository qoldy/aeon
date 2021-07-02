package com.example.aeon.networking

import com.example.aeon.data.Payment
import com.google.gson.annotations.SerializedName

data class ListResponse(
        @SerializedName("success")
        val isSuccess:Boolean,
        @SerializedName("response")
        val list:ArrayList<Payment>
)
