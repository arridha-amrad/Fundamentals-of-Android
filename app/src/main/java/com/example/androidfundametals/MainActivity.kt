package com.example.androidfundametals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidfundametals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding;
  private val firstFragment = FirstFragment()
  private val secondFragment = SecondFragment()
  private val thirdFragment = ThirdFragment()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root;
    setContentView(view)

    setFragment(firstFragment)

    binding.bottomNavigationView2.setOnNavigationItemSelectedListener {
      when(it.itemId){
        R.id.miHome -> setFragment(firstFragment)
        R.id.miMessages -> setFragment(secondFragment)
        R.id.miProfile -> setFragment(thirdFragment)
      }
      true
    }
    binding.bottomNavigationView2.getOrCreateBadge(R.id.miMessages).apply {
      number = 10;
      isVisible = true
    }

  }

  private fun setFragment(fragment: Fragment){
    supportFragmentManager.beginTransaction().apply {
      replace(R.id.flFragment, fragment)
      commit()
    }
  }

}