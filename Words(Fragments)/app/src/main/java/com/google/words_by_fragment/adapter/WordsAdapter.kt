package com.google.words_by_fragment.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.words_by_fragment.R

class WordsAdapter(private val context: Context, private val words: List<String>) :
    RecyclerView.Adapter<WordsAdapter.WordsViewsHolder>() {

    class WordsViewsHolder(itemView: View) : ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewsHolder {
        return WordsViewsHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(holder: WordsViewsHolder, position: Int) {
        val word = words[position]
        holder.button.text = word

        holder.button.setOnClickListener {
            val searchPrefix = "https://www.google.com/search?q="
            val url: Uri = Uri.parse("${searchPrefix}${word}")
            val intent = Intent(Intent.ACTION_VIEW, url)
            context.startActivity(intent)
        }
    }
}