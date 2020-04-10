package com.example.vakho_kavtaradze_davaleba3


import android.app.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }
    private fun init(){
        val intent = intent

        SecondButton.setOnClickListener(){
            OpenMainActivaty()
        }

    }
    private fun OpenMainActivaty(){
        val intent = intent
        intent.putExtra("Title",Title.text.toString())
        intent.putExtra("Description",Description.text.toString())
        setResult(Activity.RESULT_OK,intent)

        finish()
    }
}
