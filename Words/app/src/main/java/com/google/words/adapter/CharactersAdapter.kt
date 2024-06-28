package com.google.words.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.words.R
import com.google.words.WordsActivity

class CharactersAdapter(private val context: Context, private val characters: List<Char>) :
    RecyclerView.Adapter<CharactersAdapter.CharactersViewsHolder>() {

    class CharactersViewsHolder(itemView: View) : ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewsHolder {
        return CharactersViewsHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharactersViewsHolder, position: Int) {
        val character = characters[position]
        holder.button.text = character.toString()

        holder.button.setOnClickListener {
            val intent = Intent(context, WordsActivity::class.java)
            intent.putExtra("character", character)
            context.startActivity(intent)
        }
    }
}