package com.wanderingthinkter.emojidictionary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_emoji_detail.*

class EmojiDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emoji_detail)
    }

    override fun onStart() {
        super.onStart()
        val emojiCode = intent.extras.getString("emojiCode")
        val emojiName = intent.extras.getString("emojiName")
        val emojiDesc = intent.extras.getString("emojiDescription")
        emojiDetailTextView.text = emojiCode
        emojiNameTxt.text = emojiName
        emojiDescTxt.text = emojiDesc
    }
}
