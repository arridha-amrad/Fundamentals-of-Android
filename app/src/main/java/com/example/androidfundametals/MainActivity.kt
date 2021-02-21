package com.example.androidfundametals

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfundametals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding;
   private lateinit var toggle: ActionBarDrawerToggle

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
      val view = binding.root;
      setContentView(view)

      val sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE)
      val editor = sharedPreferences.edit()

      binding.apply {

         btnSave.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val isAdult = cbAdult.isChecked

            editor.apply {
               putString("name", name)
               putInt("age", age)
               putBoolean("isAdult", isAdult)
               apply()
            }
         }

         btnLoad.setOnClickListener {
            val name = sharedPreferences.getString("name", null)
            val age = sharedPreferences.getInt("age", 0)
            val isAdult = sharedPreferences.getBoolean("isAdult", false)

            etName.setText(name)
            etAge.setText(age.toString())
            cbAdult.isChecked = isAdult
         }

      }
   }

}