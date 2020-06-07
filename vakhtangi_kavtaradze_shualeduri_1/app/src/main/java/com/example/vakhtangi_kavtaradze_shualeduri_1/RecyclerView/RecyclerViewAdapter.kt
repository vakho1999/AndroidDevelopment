package com.example.vakhtangi_kavtaradze_shualeduri_1.RecyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vakhtangi_kavtaradze_shualeduri_1.Models.ItemModel
import com.example.vakhtangi_kavtaradze_shualeduri_1.R
import com.example.vakhtangi_kavtaradze_shualeduri_1.SecondActivity
import kotlinx.android.synthetic.main.recyclerview_layout.view.*

class RecyclerViewAdapter(private val items:ArrayList<ItemModel>, private val activity: SecondActivity):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent.context).inflate(
                R.layout.recyclerview_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var model: ItemModel
        fun onBind(){
            model = items[adapterPosition]
            itemView.image.setImageResource(model.image)
            itemView.text1.text = model.Country
            itemView.text2.text = model.deaths
            itemView.text3.text = model.population.toString()

        }
    }
}