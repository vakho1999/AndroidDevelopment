package com.example.vakhtangi_kavtaradze_davaleba2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }
    private fun init(){
        val intent = intent
        Name1.setText(intent.extras!!.getString("Name",""))
        Surname1.setText(intent.extras!!.getString("Surname",""))
        Email1.setText(intent.extras!!.getString("Email",""))
        age1.setText(intent.extras!!.getInt("age",0).toString())
        Bdate1.setText(intent.extras!!.getString("Bdate",""))
        gender1.setText(intent.extras!!.getString("gender",""))
        SecondButton.setOnClickListener(){
            OpenMainActivaty()
        }

    }
    private fun OpenMainActivaty(){
        val intent = intent
        intent.putExtra("Name",Name1.text.toString())
        intent.putExtra("Surname",Surname1.text.toString())
        intent.putExtra("Email",Email1.text.toString())
        intent.putExtra("age",age1.text.toString().toInt())
        intent.putExtra("Bdate",Bdate1.text.toString())
        intent.putExtra("gender",gender1.text.toString())
        setResult(Activity.RESULT_OK,intent)

        finish()
    }
}
