package com.frantun.bootcampbcpsession6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.frantun.bootcampbcpsession6.adapter.DepthPageTransformer
import com.frantun.bootcampbcpsession6.adapter.PhotosPagerAdapter
import com.frantun.bootcampbcpsession6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUI()
        setListeners()
    }

    private fun setUI() {
        photosPagerAdapter = PhotosPagerAdapter(buildList(), this)
        binding.photosViewPager.adapter = photosPagerAdapter
//        binding.photosViewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        binding.photosViewPager.setPageTransformer(DepthPageTransformer())
    }

    private fun buildList() = listOf(
        R.drawable.cat_1,
        R.drawable.cat_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_5
    )

    private fun setListeners() {
        binding.photosViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                binding.counterTextView.text =
                    getString(R.string.counter_photo, position + 1, buildList().size)
            }
        })
    }
}
