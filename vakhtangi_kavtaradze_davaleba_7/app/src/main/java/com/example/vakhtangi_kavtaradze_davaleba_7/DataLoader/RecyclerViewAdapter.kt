package com.example.vakhtangi_kavtaradze_davaleba_7.DataLoader

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import com.example.vakhtangi_kavtaradze_davaleba_7.Serializer.Serializer

class RecyclerViewAdapter(
    private val Serializer: ArrayList<Serializer>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: HotelsRecyclerviewLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            binding.Serializer = Serializer[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HotelsRecyclerviewLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = Serializer.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }
}