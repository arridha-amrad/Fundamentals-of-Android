package com.example.androidfundametals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfundametals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root;
    setContentView(view)

    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()

    supportFragmentManager.beginTransaction().apply {
      replace(R.id.flFragment, firstFragment)
      commit()
    }

    binding.apply {
      btnFragment1.setOnClickListener {
        supportFragmentManager.beginTransaction().apply {
          replace(R.id.flFragment, firstFragment)
          commit()
        }
      }

      btnFragment2.setOnClickListener {
        supportFragmentManager.beginTransaction().apply {
          replace(R.id.flFragment, secondFragment)
          // let you go back to prev fragment
          addToBackStack(null)
          commit()
        }
      }
    }
  }

}