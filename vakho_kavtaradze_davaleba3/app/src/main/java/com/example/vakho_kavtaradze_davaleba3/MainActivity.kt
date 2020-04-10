package com.example.vakho_kavtaradze_davaleba3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    val items = ArrayList<ItemModel>()
    private lateinit var adapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){

        addButton.setOnClickListener(){
            adapter.notifyItemInserted(items.size -1)
            recyclerView.scrollToPosition(items.size -1)
            OpenSecondActivity()

        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(items,this)
        recyclerView.adapter = RecyclerViewAdapter(items,this)
    }
    @SuppressLint("SimpleDateFormat")
    private fun setItems(text1: String, text2 : String){

        val date = SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Date())
        items.add(ItemModel(R.mipmap.ic_iconed,text1,text2,date))

    }
    private fun OpenSecondActivity(){
        val intent = Intent(this,SecondActivity::class.java)
        startActivityForResult(intent,1)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val Title = data!!.extras!!.getString("Title","")
        val Surname= data!!.extras!!.getString("Description","")
        setItems(Title,Surname)
        super.onActivityResult(requestCode, resultCode, data)
    }
}
