package com.example.androidfundametals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.androidfundametals.databinding.CustomToastBinding
import com.example.androidfundametals.databinding.ToastActivityBinding

class MainActivity : AppCompatActivity() {
  private lateinit var toastBinding: ToastActivityBinding
  private lateinit var cusToastBinding: CustomToastBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    toastBinding = ToastActivityBinding.inflate(layoutInflater)
    setContentView(toastBinding.root)

    cusToastBinding = CustomToastBinding.inflate(layoutInflater)

    toastBinding.btnToast.setOnClickListener{
//      Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();
      Toast(this).apply {
        duration = Toast.LENGTH_SHORT
        view = layoutInflater.inflate(R.layout.custom_toast, cusToastBinding.root)
        show()
      }
    }
  }

}