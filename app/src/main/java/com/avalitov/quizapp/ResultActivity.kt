package com.avalitov.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

lateinit var tvUserName : TextView
lateinit var tvScore : TextView
lateinit var btnFinish : Button

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvUserName = findViewById(R.id.tv_username)
        tvScore = findViewById(R.id.tv_yourScoreIs)
        btnFinish = findViewById(R.id.btn_finish)

        val username = intent.getStringExtra(Constants.USER_NAME)
        tvUserName.text = username

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tvScore.text = "Your score is $correctAnswers out of $totalQuestions!"

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}