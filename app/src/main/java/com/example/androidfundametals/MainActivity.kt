package com.example.androidfundametals

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.androidfundametals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root;
    setContentView(view)

    val images = listOf<Int>(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img6,
    )
    val vpAdapter = ViewPagerAdapter(images)
    binding.viewPager.apply {
      adapter = vpAdapter
      orientation = ViewPager2.ORIENTATION_VERTICAL

      beginFakeDrag()
      fakeDragBy(-10f)
      endFakeDrag()
    }

  }

}