package com.example.vakho_kavtaradze_davaleba3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recayclerview_layout.view.*

class RecyclerViewAdapter(private val items:ArrayList<ItemModel>,private val activity: MainActivity):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                parent.context).inflate(
                R.layout.recayclerview_layout,parent,false))
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
            itemView.text1.text = model.title
            itemView.text2.text = model.description
            itemView.text3.text = model.create
            itemView.setOnLongClickListener(){
                activity.items.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
                true
            }
        }
    }
}