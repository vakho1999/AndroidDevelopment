package com.example.vakhtangi_kavtaradze_shualeduri_1


import android.app.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vakhtangi_kavtaradze_shualeduri_1.DataLoader.CustomCallback
import com.example.vakhtangi_kavtaradze_shualeduri_1.DataLoader.Dataloader
import com.example.vakhtangi_kavtaradze_shualeduri_1.DataLoader.Serializer
import com.example.vakhtangi_kavtaradze_shualeduri_1.Models.ItemModel
import com.example.vakhtangi_kavtaradze_shualeduri_1.RecyclerView.RecyclerViewAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {
    val items = ArrayList<ItemModel>()
    lateinit var adapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        d("Info2: ","aqamde modis")
      Dataloader.getRequest("statistics", object : CustomCallback {
         override fun onSuccess(result: String){

                val Serialized = Gson().fromJson(
                   result,
                   Serializer::class.java
               )

                d("Info", "data: ${Serialized.data}")
             for( index in Serialized.data.indices){
                 if(index.equals(40)) { // 250 mde chanaweria da bevri iqneboda 40 ic eyofa sachveneblad
                     break
                 }else{
                     val item = Serialized.data[index]
                     items.add(
                         ItemModel(

                             R.mipmap.korona,
                             "Country: "+item.country,
                             "Deaths: "+item.deaths,
                             item.population
                         )
                     )
                     
                 }
             }

            }
        })

        adapter.notifyDataSetChanged()
        init()
    }
    private fun init(){
        items.add(ItemModel(R.mipmap.corona,"Russia","10000",10000))
        adapter.notifyDataSetChanged()
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(items,this)
        recyclerView.adapter = RecyclerViewAdapter(items,this)


        SecondButton.setOnClickListener(){
            OpenMainActivaty()
        }

    }
    private fun OpenMainActivaty(){
        val intent = intent
//        intent.putExtra("Title",Title.text.toString())
//        intent.putExtra("Description",Description.text.toString())
        setResult(Activity.RESULT_OK,intent)

        finish()
    }
}
