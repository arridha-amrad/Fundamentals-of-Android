package com.example.androidfundametals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundametals.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
  private lateinit var viewBinding:ActivityThirdBinding;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewBinding = ActivityThirdBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)

    viewBinding.btnBack3.setOnClickListener {
      finish()
    }
  }
}