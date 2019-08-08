package com.wanderingthinkter.todoapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    var TODOLIST_STRINGSET = "todolist_stringset"

    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent(view.context, CreateTodo::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        updateRecycler()
    }

    fun updateRecycler() {
        var sharedPreference = getSharedPreferences("com.wanderingthinkter.todoapp.sharedprefs", Context.MODE_PRIVATE)
        var todoSet = sharedPreference.getStringSet(TODOLIST_STRINGSET, setOf()).toMutableSet()

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = TodoAdapter(todoSet)

        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.action_settings) {
            var sharedPreference = getSharedPreferences("com.wanderingthinkter.todoapp.sharedprefs", Context.MODE_PRIVATE)
            sharedPreference.edit().putStringSet(TODOLIST_STRINGSET, null).apply()
            updateRecycler()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
