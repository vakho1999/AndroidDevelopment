package com.example.vakhtangi_kavtaradze_shualeduri_1
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){

    SecondButton.setOnClickListener(){
        if(Username.text.contains("nika") and Password.text.contains("tabatadze")){
            OpenSecondActivity()
        }else{
            Toast.makeText(this,"Oops Incorrect password or Username",Toast.LENGTH_SHORT).show()
        }

    }

    }


    private fun OpenSecondActivity(){
        val intent = Intent(this,SecondActivity::class.java)
        startActivityForResult(intent,1)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
    }
}