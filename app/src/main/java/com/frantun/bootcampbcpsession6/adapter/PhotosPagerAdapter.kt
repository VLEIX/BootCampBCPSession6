package com.frantun.bootcampbcpsession6.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.frantun.bootcampbcpsession6.fragment.PhotoFragment

class PhotosPagerAdapter(private val photoList: List<Int>, fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun createFragment(position: Int): Fragment {
        return PhotoFragment.newInstance(photoList[position])
    }
}