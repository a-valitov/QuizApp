package com.avalitov.quizapp

data class Question (
    val id: Int,
    val question: String,
    val imageNumber: Int,

    val OptionOne: String,
    val OptionTwo: String,
    val OptionThree: String,
    val OptionFour: String,

    val correctAnswer: Int
)