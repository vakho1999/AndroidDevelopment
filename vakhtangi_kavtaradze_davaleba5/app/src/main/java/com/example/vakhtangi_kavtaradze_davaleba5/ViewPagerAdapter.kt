package com.example.vakhtangi_kavtaradze_davaleba5

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager,private val items:MutableList<ViewPagerModel>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int) : Fragment{
        val fragment = DefaultFragment()
        fragment.model = items[position]
        return fragment
    }

    override fun getCount() = items.size
}