package com.wanderingthinkter.emojidictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager : GridLayoutManager
    lateinit var adapter : EmojiAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = GridLayoutManager(this, 3)
        recyclerView.layoutManager = layoutManager

        val emoji1 = Emoji("Grinning Face", "\uD83D\uDE00", "A face that shows grinning.")
        val emoji2 = Emoji("Face with tears of joy", "\uD83D\uDE02", "A face that show extra happiness")
        val emoji3 = Emoji("Winiking Face", "\uD83D\uDE09", "A face that shows a winking person")

        adapter = EmojiAdapter(arrayListOf(emoji1, emoji2, emoji3))
        recyclerView.adapter = adapter
    }
}
