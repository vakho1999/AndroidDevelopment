package com.example.vakhtangi_kavtaradze_davaleba5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUsers()

    }
//    override fun onClick(v: View?) {
//        when(v!!.id){
//            R.id.FirstButton -> {
//                addFragment(R.id.FirstContainer,DefaultFragment(),"DefaultFragment",false)
//            }
//            R.id.SecondButton -> {
//                addFragment(R.id.SecondContainer,
//                    SecondFragment(),"SecondFragment",false)
//            }
//        }
//    }
//    private fun addFragment(container:Int, fragment: Fragment, tag:String,hasBack: Boolean){
//        val transaction = supportFragmentManager.beginTransaction()
//        val defaultFragment = DefaultFragment()
//        if (hasBack){
//            transaction.replace(container,fragment,tag)
//            transaction.addToBackStack("DefaultFragment")
//        }else{
//            transaction.replace(container,fragment)
//        }
//
//        transaction.commit()
//    }
    private fun init(Users:Serializer){
    val items = mutableListOf<ViewPagerModel>()
    for(index in Users.data.indices){
        items.add(ViewPagerModel(Users.data[index].avatar)) //TODO firstname,lastname,email
    }

    viewPager.adapter = ViewPagerAdapter(supportFragmentManager,items)
//        FirstButton.setOnClickListener(this)
//        SecondButton.setOnClickListener(this)
    }
    private fun getUsers() {
        Dataloader.getRequest("users", object : CustomCallback {
            override fun onSuccess(result: String){

                val Serialized = Gson().fromJson(
                    result,
                    Serializer::class.java
                )
                d("vakho", "First is this")
                d("Info", "data: ${Serialized.data}")

                init(Serialized);
            }
        })
    }





    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}

