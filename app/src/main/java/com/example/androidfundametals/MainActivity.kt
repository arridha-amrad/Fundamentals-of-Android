package com.example.androidfundametals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidfundametals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root;
    setContentView(view)

    binding.btnSubmit.setOnClickListener {
      val firstName = binding.etFirstName.editText?.text.toString()
      val lastName = binding.etLastName.editText?.text.toString()
      val nationality = binding.etNationality.editText?.text.toString()
      val person = Person(firstName, lastName, nationality)
      Log.d("MainActivity", "$firstName $lastName $nationality")
      Intent(this, SecondActivity::class.java).also {
        it.putExtra("EXTRA_PERSON", person)
        startActivity(it)
      }

    }

  }

}