package com.example.vakhtangi_kavtaradze_davaleba5

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_default.*
import kotlinx.android.synthetic.main.fragment_default.view.*

/**
 * A simple [Fragment] subclass.
 */
class DefaultFragment : Fragment() {
    private lateinit var rootview: View
    lateinit var model: ViewPagerModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootview = inflater.inflate(R.layout.fragment_default, container, false)
        init()
        return rootview
    }
    private fun init(){
        d("show","${model.avatar}")
//        Glide.with(rootview).load(model.avatar)
//            .placeholder(android.R.drawable.progress_indeterminate_horizontal)
//            .error(android.R.drawable.stat_notify_error)
//            .into(Image);
        rootview.email.setText(model.email);
        rootview.firstname.setText(model.Firstname);
        rootview.lastname.setText(model.Lastname);
    }
}
