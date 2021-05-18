package com.avalitov.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

lateinit var tvQuestion: TextView
lateinit var ivImage: ImageView
lateinit var progressBar: ProgressBar
lateinit var tvProgress: TextView
lateinit var tvOptionOne : TextView
lateinit var tvOptionTwo: TextView
lateinit var tvOptionThree : TextView
lateinit var tvOptionFour : TextView

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        tvOptionFour = findViewById<TextView>(R.id.tv_option_four)

        val questionsList = Constants.getQuestions()
        Log.i("Questions Size", "${questionsList.size}")

        val currentPosition : Int = 1

        val question : Question? = questionsList[currentPosition - 1]

        progressBar.progress = currentPosition
        tvProgress.text = "$currentPosition/" + progressBar.max

        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.imageNumber)

        tvOptionOne.text = question.OptionOne
        tvOptionTwo.text = question.OptionTwo
        tvOptionThree.text = question.OptionThree
        tvOptionFour.text = question.OptionFour

    }


}