package com.example.androidfundametals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundametals.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
  private lateinit var viewBinding: ActivitySecondBinding;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState);
    viewBinding = ActivitySecondBinding.inflate(layoutInflater)
    val view = viewBinding.root
    setContentView(view);

    viewBinding.btnNext2.setOnClickListener{
      Intent(this, ThirdActivity::class.java).also {
        startActivity(it)
      }
    }

    viewBinding.btnBack2.setOnClickListener{
      finish()
    }
  }
}