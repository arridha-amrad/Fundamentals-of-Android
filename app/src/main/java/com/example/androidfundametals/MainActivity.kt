package com.example.androidfundametals

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidfundametals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding;

  @RequiresApi(Build.VERSION_CODES.M)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root;
    setContentView(view)

    val todoList = mutableListOf<Todo>(
      Todo("eat with egg", false),
      Todo("go shopping", true),
      Todo("debugging e-commerce android", false),
      Todo("meeting with mr.James", false)
    )

    val adapter = TodoAdapter(todoList)
    binding.rvTodo.adapter = adapter
    binding.rvTodo.layoutManager = LinearLayoutManager(this)

    binding.apply {
      btnAdd.setOnClickListener {
        val title = etTodo.text.toString()
        val newTodo = Todo(title, false)
        todoList.add(0, newTodo)
        adapter.notifyItemInserted(0)
        etTodo.text = null
        Toast.makeText(this@MainActivity, "New todo added", Toast.LENGTH_LONG).show()

        // dismiss the keyboard
        val imm: InputMethodManager =
          getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(etTodo.getWindowToken(), 0)
      }
    }

  }

}