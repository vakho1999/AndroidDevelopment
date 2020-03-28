package com.example.vakho_kavtaradze_davaleba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        button.setOnClickListener{
            if(email.text.toString().isEmpty() ){
                Toast.makeText(this,"You are missing Email Field",Toast.LENGTH_SHORT).show()
            }
            if(password.text.toString().isEmpty()){
                Toast.makeText(this,"You are missing Password Field",Toast.LENGTH_SHORT).show()
            }
            if (email.text.toString().isNotEmpty() and password.text.toString().isNotEmpty()){
                Toast.makeText(this,"Congrats you are logined in",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
