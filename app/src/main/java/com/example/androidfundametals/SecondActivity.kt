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

    val person = intent.getSerializableExtra("EXTRA_PERSON") as Person

    viewBinding.tvDescription.text = "${person.firstName} ${person.lastName} is from ${person.nationality}"

    viewBinding.btnBack.setOnClickListener{
      finish()
    }
  }
}