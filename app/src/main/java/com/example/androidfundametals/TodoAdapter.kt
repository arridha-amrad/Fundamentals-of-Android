package com.example.androidfundametals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    val todos: List<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvTodo: TextView = itemView.findViewById(R.id.tvTodo);
        var cbTodo: CheckBox = itemView.findViewById(R.id.cbTodo);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.apply {
            tvTodo.text = todos[position].title;
            cbTodo.isChecked = todos[position].isChecked;
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}