package com.wanderingthinkter.todoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_complete_todo.*

class CompleteTodo : AppCompatActivity() {

    var TODOLIST_STRINGSET = "todolist_stringset"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_todo)

        val title = intent.extras.getString("title")
        titleTxt.text = title

        completeBtn.setOnClickListener {
            var sharedPreference = getSharedPreferences("com.wanderingthinkter.todoapp.sharedprefs", Context.MODE_PRIVATE)
            var todoSet = sharedPreference.getStringSet(TODOLIST_STRINGSET, setOf()).toMutableSet()

            todoSet.remove(title)

            sharedPreference.edit().putStringSet(TODOLIST_STRINGSET, todoSet).apply()
            finish()
        }

    }
}
