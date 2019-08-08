package com.wanderingthinkter.todoapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todorow.view.*

class TodoAdapter(var todoSet: MutableSet<String>) : RecyclerView.Adapter<TodoAdapter.TodoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        return TodoHolder(LayoutInflater.from(parent.context).inflate(R.layout.todorow, parent, false))
    }

    override fun getItemCount(): Int {
        return todoSet.size
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.bindTodo(todoSet.elementAt(position), position)
    }

    class TodoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        val view = v
        var title = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindTodo(title: String, position: Int) {
            this.title = title
            view.todoRow.text = "${position + 1}) ${title}"
        }

        override fun onClick(p0: View?) {
            val intent = Intent(view.context, CompleteTodo::class.java)
            intent.putExtra("title", title)
            startActivity(view.context, intent, null)
        }

    }
}