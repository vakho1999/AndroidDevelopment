package com.example.vakhtangi_kavtaradze_davaleba2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        MainButton.setOnClickListener(){
            OpenSecondActivaty()
        }
    }
    private fun OpenSecondActivaty(){
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("Name",Name.text.toString())
        intent.putExtra("Surname",Surname.text.toString())
        intent.putExtra("Email",Email.text.toString())
        intent.putExtra("age",age.text.toString().toInt())
        intent.putExtra("Bdate",Bdate.text.toString())
        intent.putExtra("gender",gender.text.toString())
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        vinaidan darwmunebuli var result kodi rasac daabrulebs conditions vtoveb
        Name.setText(data!!.extras!!.getString("Name",""))
        Surname.setText(data!!.extras!!.getString("Surname",""))
        Email.setText(data!!.extras!!.getString("Email",""))
        age.setText(data!!.extras!!.getInt("age",0).toString())
        Bdate.setText(data!!.extras!!.getString("Bdate",""))
        gender.setText(data!!.extras!!.getString("gender",""))
        super.onActivityResult(requestCode, resultCode, data)
    }
}
