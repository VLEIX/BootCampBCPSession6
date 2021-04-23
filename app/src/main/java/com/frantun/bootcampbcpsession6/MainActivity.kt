package com.frantun.bootcampbcpsession6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.frantun.bootcampbcpsession6.adapter.PhotosPagerAdapter
import com.frantun.bootcampbcpsession6.adapter.ZoomOutPageTransformer
import com.frantun.bootcampbcpsession6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var photosPagerAdapter: PhotosPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUI()
    }

    private fun setUI() {
        photosPagerAdapter = PhotosPagerAdapter(buildList(), this)
        binding.photosViewPager.adapter = photosPagerAdapter
//        binding.photosViewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        binding.photosViewPager.setPageTransformer(ZoomOutPageTransformer())
    }

    private fun buildList() = listOf(
        R.drawable.cat_1,
        R.drawable.cat_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_5
    )
}

// despliegue desde cero
// workmanager -> courutines
// RA