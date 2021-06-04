package com.avalitov.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView
import java.lang.reflect.Type

lateinit var tvQuestion: TextView
lateinit var ivImage: ImageView
lateinit var progressBar: ProgressBar
lateinit var tvProgress: TextView
lateinit var tvOptionOne : TextView
lateinit var tvOptionTwo: TextView
lateinit var tvOptionThree : TextView
lateinit var tvOptionFour : TextView
lateinit var btnSubmit : Button

//@Suppress("DEPRECATION")
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers : Int = 0
    private var mUserName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//        actionBar?.hide()


        //getting username from the previous activity
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
        tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
        tvOptionFour = findViewById<TextView>(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        mQuestionsList = Constants.getQuestions()
        //Log.i("Questions Size", "${questionsList.size}")

        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
        btnSubmit.isClickable = false
    }

    private fun setQuestion() {
        
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()    // set all options to default view (none is selected)

//        if(mCurrentPosition > mQuestionsList!!.size) {
//            btnSubmit.text = "FINISH1"
//        } else {
            btnSubmit.text = "SUBMIT"
//        }

        //setting question fields to views
        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition/" + progressBar.max
        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.imageNumber)
        tvOptionOne.text = question.OptionOne
        tvOptionTwo.text = question.OptionTwo
        tvOptionThree.text = question.OptionThree
        tvOptionFour.text = question.OptionFour

        //enable options so user could pick again
        tvOptionOne.isClickable = true
        tvOptionTwo.isClickable = true
        tvOptionThree.isClickable = true
        tvOptionFour.isClickable = true
        btnSubmit.isClickable = false

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
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0) {  //if no option is selected?
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        } else -> {
                            //moving to a final activity
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {    //if user has selected an option
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    //disable options so user couldn't pick
                    tvOptionOne.isClickable = false
                    tvOptionTwo.isClickable = false
                    tvOptionThree.isClickable = false
                    tvOptionFour.isClickable = false

                    if(question!!.correctAnswer != mSelectedOptionPosition) {   //if the answer is incorrect
                        setAnswerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {    // if the answer is correct
                        mCorrectAnswers++
                    }

                    setAnswerView(question.correctAnswer, R.drawable.correct_option_border)

                    if(mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit.text = "FINISH"
                    } else {
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun setAnswerView(answer: Int, drawableView: Int) {
        when(answer){
            1 -> {
                tvOptionOne.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            2 -> {
                tvOptionTwo.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            3 -> {
                tvOptionThree.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            4 -> {
                tvOptionFour.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        btnSubmit.isClickable = true
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