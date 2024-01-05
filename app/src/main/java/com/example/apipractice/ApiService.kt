package com.example.apipractice

import retrofit.Call
import retrofit.http.GET

interface ApiService {
    @GET("jokes/random")
    fun getjokes(): Call<DataModel>

}