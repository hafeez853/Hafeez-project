package com.example.apipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit

class SecondActivity : AppCompatActivity() {
    lateinit var courseRV: RecyclerView
    lateinit var loadingPB: ProgressBar
    lateinit var courseRVAdapter: CourseRVAdapter
    lateinit var courseList: ArrayList<CourseRVModal>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        courseRV = findViewById(R.id.idRVCourses)
        loadingPB = findViewById(R.id.idPBLoading)
        courseList = ArrayList()
        getAllCourses()
    }

    private fun getAllCourses() {
        val retrofit = Retrofit.Builder().baseUrl("https://jsonkeeper.com/b/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
        val call:Call<ArrayList<CourseRVModal>?>? = retrofitAPI.getAllCourses()
        call!!.enqueue(object : Callback<ArrayList<CourseRVModal>?>{
            override fun onResponse(
                response: Response<ArrayList<CourseRVModal>?>?,
                retrofit: Retrofit?
            ) {
                if (response!!.isSuccess){
                    loadingPB.visibility = View.GONE
                    courseList = response.body()!!

                }else{
                    Toast.makeText(this@SecondActivity, "Failed to fetch courses", Toast.LENGTH_SHORT).show()
                }
                courseRVAdapter = CourseRVAdapter(courseList)
                courseRV.adapter = courseRVAdapter

            }

            override fun onFailure(t: Throwable?) {
                Toast.makeText(this@SecondActivity, "No Network", Toast.LENGTH_SHORT).show()
            }
        })
    }
}