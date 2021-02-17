package com.example.androidfundametals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androidfundametals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding;

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root;
    setContentView(view)

    val addContactDialog = AlertDialog.Builder(this)
        .setTitle("Add contact")
        .setMessage("Do you want to add dilsah to your contact list ?")
        .setIcon(R.drawable.ic_add_contact)
        .setPositiveButton("Yes"){_, _ ->
          Toast.makeText(this,  "dilsah is added successfully", Toast.LENGTH_SHORT).show()
        }
        .setNegativeButton("No"){_, _ ->
          Toast.makeText(this, "You cancel to add dilsah in your contact", Toast.LENGTH_LONG).show()
        }

    binding.btnDialog1.setOnClickListener {
      addContactDialog.show()
    }

    val options = arrayOf("First item", "Second item", "Third item")
    val singleChoiceDialog = AlertDialog.Builder(this)
        .setTitle("Choose one of this options")
        .setSingleChoiceItems(options, 0){_, i ->
          Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
        }
        .setPositiveButton("Accept"){_, _ ->
          Toast.makeText(this, "You accept the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
        }
        .setNegativeButton("Decline"){_, _ ->
          Toast.makeText(this, "You decline the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
        }

    binding.btnDialog2.setOnClickListener {
      singleChoiceDialog.show()
    }

    val acceptedItem = mutableListOf<String>()

    val multiChoiceDialog = AlertDialog.Builder(this)
      .setTitle("Please choose your item")
        .setMultiChoiceItems(options, booleanArrayOf(false, false, false)){_, i, isChecked ->
          if (isChecked){
            acceptedItem.add(options[i])
            Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
          } else {
            acceptedItem.remove(options[i])
            Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
          }
        }
        .setPositiveButton("Accept"){_, _ ->
          Toast.makeText(this, "You accept the MultipleChoice : $acceptedItem", Toast.LENGTH_LONG).show()
        }
        .setNegativeButton("Decline"){_, _ ->
          Toast.makeText(this, "You decline the MultipleChoice", Toast.LENGTH_LONG).show()
        }

    binding.btnDialog3.setOnClickListener {
      multiChoiceDialog.show()
    }

  }

}