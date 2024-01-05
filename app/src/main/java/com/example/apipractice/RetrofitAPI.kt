package com.example.apipractice

import retrofit.Call
import retrofit.http.GET

interface RetrofitAPI {

    @GET("0RH6")
    fun getAllCourses(): Call<ArrayList<CourseRVModal>?>?
}