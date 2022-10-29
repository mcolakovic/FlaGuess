package com.example.flaguess

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.TRANSPARENT
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USERNAME)
        val user = findViewById(R.id.userID) as TextView
        user.text = username

        val totalQuestions = intent.getIntExtra(Constants.QUESTIONS,0)
        val correctQuestions = intent.getIntExtra(Constants.CORRECT,0)
        val score = findViewById(R.id.scoreID) as TextView
        score.text = "Tačan broj odgovora je $correctQuestions od $totalQuestions"

        val finished = findViewById(R.id.finishID) as Button
        finished.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}