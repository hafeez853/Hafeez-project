package com.example.apipractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btn_jokes: Button
    private lateinit var tv_jokes: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var nextbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_jokes = findViewById(R.id.btn_joke)
        tv_jokes = findViewById(R.id.tv_joke)
        progressBar = findViewById(R.id.idLoadingPB)
        nextbtn = findViewById(R.id.nextBtn)
        nextbtn.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        btn_jokes.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            ApiCall().getJokes(this) { jokes ->
                tv_jokes.text = jokes.value
                progressBar.visibility = View.GONE
            }
        }
    }
}