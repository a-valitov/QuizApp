package com.avalitov.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.lang.reflect.Type

lateinit var tvQuestion: TextView
lateinit var ivImage: ImageView
lateinit var progressBar: ProgressBar
lateinit var tvProgress: TextView
lateinit var tvOptionOne : TextView
lateinit var tvOptionTwo: TextView
lateinit var tvOptionThree : TextView
lateinit var tvOptionFour : TextView

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0


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

        mQuestionsList = Constants.getQuestions()
        //Log.i("Questions Size", "${questionsList.size}")

        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
    }

    private fun setQuestion() {

        mCurrentPosition = 1
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()    // set all options to default view (none is selected)

        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition/" + progressBar.max

        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.imageNumber)

        tvOptionOne.text = question.OptionOne
        tvOptionTwo.text = question.OptionTwo
        tvOptionThree.text = question.OptionThree
        tvOptionFour.text = question.OptionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_border
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tvOptionOne, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tvOptionTwo, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tvOptionThree, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tvOptionFour, 4)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this,
                R.drawable.selected_option_border
        )
    }


}