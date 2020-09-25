package com.samone.project6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPageAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){

    val list = arrayListOf<Fragment>()

    fun add(fragment: Fragment){
        list.add(fragment)
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int = list.size

}