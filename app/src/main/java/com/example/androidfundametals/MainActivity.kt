package com.example.androidfundametals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidfundametals.databinding.ActivityButtonBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityButtonBinding;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityButtonBinding.inflate(layoutInflater)
    val view = binding.root;
    setContentView(view)

    binding.btnSubmit.setOnClickListener {
      val firstName = binding.etFirstName.editText?.text.toString()
      val lastName = binding.etLastName.editText?.text.toString()
      val nationality = binding.etNationality.editText?.text.toString();

      Log.d("MainActivity", "$lastName $firstName comes from $nationality")
    }


  }

}