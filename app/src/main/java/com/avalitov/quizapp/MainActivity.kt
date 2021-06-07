package com.avalitov.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

lateinit var btn_start : Button
lateinit var et_name : AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start = findViewById(R.id.btn_start)
        et_name = findViewById(R.id.et_name)

        btn_start.setOnClickListener {

            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this, "Пожалуйста, введите имя", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())       //sending username to the next activity
                startActivity(intent)
                finish()
            }
        }
    }
}