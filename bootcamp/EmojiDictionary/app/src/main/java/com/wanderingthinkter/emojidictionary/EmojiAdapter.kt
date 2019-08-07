package com.wanderingthinkter.emojidictionary

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*

class EmojiAdapter(val emojis : ArrayList<Emoji>) : RecyclerView.Adapter<EmojiAdapter.TextHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextHolder {
        return TextHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return emojis.size
    }

    override fun onBindViewHolder(holder: TextHolder, position: Int) {
        holder.bindEmoji(emojis[position])
    }

    class TextHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {

        var view : View = v
        lateinit var emoji: Emoji

        init {
            v.setOnClickListener(this)
        }

        fun bindEmoji(emoji : Emoji) {
            this.emoji = emoji
            view.itemTextView.text = emoji.code
        }

        override fun onClick(v: View?) {
            val detailIntent = Intent(view.context, EmojiDetailActivity::class.java)
            detailIntent.putExtra("emojiCode", emoji.code)
            detailIntent.putExtra("emojiName", emoji.name)
            detailIntent.putExtra("emojiDescription", emoji.description)
            startActivity(view.context, detailIntent, null)
        }

    }
}