package com.example.vakhtangi_kavtaradze_davaleba_7.DataBinding

import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.hotels_recyclerview_layout.view.*


object DataBinding {
    @JvmStatic
    @BindingAdapter("src")
    fun setImage(imageView: ImageView, image: String) {
        Glide.with(imageView.context)
            .load(image)
            .into(imageView.Image)
    }

    
}