package com.example.aeon.networking

import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @Multipart
    @POST("login")
    suspend fun login(@Header("app-key")apiKey:String, @Header("v") version:String,
              @Part("login") login:RequestBody,
              @Part("password") password:RequestBody):Response<LoginResponse>

    @GET("payments")
    suspend fun getList(@Header("app-key")apiKey:String, @Header("v") version:String,
    @Query("token") token:String):Response<ListResponse>
}