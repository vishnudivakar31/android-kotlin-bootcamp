package com.wanderingthinkter.todoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_create_todo.*

class CreateTodo : AppCompatActivity() {

    var TODOLIST_STRINGSET = "todolist_stringset"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_todo)

        saveBtn.setOnClickListener {
            if(itemTxt.text.toString().isNotEmpty()) {
                var title = itemTxt.text.toString()

                if(importantCheckBox.isChecked) {
                    title += "\uD83D\uDCCD"
                }

                var sharedPreference = getSharedPreferences("com.wanderingthinkter.todoapp.sharedprefs", Context.MODE_PRIVATE)
                var todoSet = sharedPreference.getStringSet(TODOLIST_STRINGSET, setOf()).toMutableSet()

                todoSet.add(title)
                sharedPreference.edit().putStringSet(TODOLIST_STRINGSET, todoSet).apply()

                finish()
            } else {
                val snackbar = Snackbar.make(it, getText(R.string.noitem_warn), Snackbar.LENGTH_LONG)
                snackbar.show()
            }
        }
    }
}
