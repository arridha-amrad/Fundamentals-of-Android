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

      toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
      binding.drawerLayout.addDrawerListener(toggle)
      toggle.syncState()

      supportActionBar?.setDisplayHomeAsUpEnabled(true)

      binding.navView.setNavigationItemSelectedListener {
         when(it.itemId) {
            R.id.miItem1 -> Toast.makeText(this, "Item one selected", Toast.LENGTH_SHORT).show()
            R.id.miItem2 -> Toast.makeText(this, "Item two selected", Toast.LENGTH_SHORT).show()
            R.id.miItem3 -> Toast.makeText(this, "Item three selected", Toast.LENGTH_SHORT).show()
         }
         true
      }

   }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
      // when working with drawer we need to setup this
      if(toggle.onOptionsItemSelected(item)){
         return true
      }
      return super.onOptionsItemSelected(item)
   }

}