package com.example.apipractice

import android.content.Context
import android.widget.Toast
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit

class ApiCall {
    fun getJokes(context: Context, callback: (DataModel) -> Unit) {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("https://api.chucknorris.io/").addConverterFactory(
                GsonConverterFactory.create()
            ).build()
        val service: ApiService = retrofit.create(ApiService::class.java)
        val cal: Call<DataModel> = service.getjokes()
        cal.enqueue(object : Callback<DataModel> {
            override fun onResponse(response: Response<DataModel>?, retrofit: Retrofit?) {
                if (response!!.isSuccess) {
                    val jokes: DataModel = response.body() as DataModel
                    callback(jokes)
                }
            }

            override fun onFailure(t: Throwable?) {
                Toast.makeText(context, "No internet Connection", Toast.LENGTH_SHORT).show()
            }
        })


    }
}