package com.example.vakhtangi_kavtaradze_davaleba_7


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vakhtangi_kavtaradze_davaleba_7.DataLoader.DataLoader
import com.example.vakhtangi_kavtaradze_davaleba_7.DataLoader.RecyclerViewAdapter
import com.example.vakhtangi_kavtaradze_davaleba_7.Serializer.CustomCallback
import com.example.vakhtangi_kavtaradze_davaleba_7.Serializer.Serializer
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerViewAdapter
    private var Serializer = ArrayList<Serializer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        ) as ActivityMainBinding

        init()
    }


    private fun init() {
        DataLoader.getRequest(
            "5edb4d643200002a005d26f0", object : CustomCallback {
                override fun onSuccess(response: String) {
                    val data = Gson().fromJson(response, Array<Serializer>::class.java).toList()

                    Serializer.addAll(data)

                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = RecyclerViewAdapter(Serializer)
                    recyclerView.adapter = adapter

                }


            }
        )
    }
}