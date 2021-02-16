package com.example.androidfundametals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    btnOrder.setOnClickListener {
      val checkedMeatId = rgMeat.checkedRadioButtonId
      val meat = findViewById<RadioButton>(checkedMeatId)

      val cheese = cbCheese.isChecked
      val salad = cbSalad.isChecked
      val onions = cbOnions.isChecked

      tvOrder.text = "You order a burger with : \n" +
          "${meat.text}" +
          (if(cheese) "\ncheese" else "") +
          (if(salad) "\nsalad" else "") +
          (if(onions) "\nonions" else "");
    }

  }

}