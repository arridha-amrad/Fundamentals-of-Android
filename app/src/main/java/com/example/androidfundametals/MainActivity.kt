package com.example.androidfundametals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.androidfundametals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root;
    setContentView(view)

    // if the array<String> is known at run time not from xml
    val items = listOf<String>("choose", "First item", "Second item", "Third item", "Fourth item")
    val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, items)
    binding.spMonths.adapter = adapter;

    binding.spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent?.getItemAtPosition(position).toString().trim() != "choose"){
          Toast.makeText(this@MainActivity, "You selected : ${parent?.getItemAtPosition(position).toString()}", Toast.LENGTH_LONG).show()
        }
      }
      override fun onNothingSelected(parent: AdapterView<*>?) {}
    }

  }

}