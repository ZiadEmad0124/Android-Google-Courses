package com.google.words_by_fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.words_by_fragment.LetterListFragmentDirections
import com.google.words_by_fragment.R

class LettersAdapter(private val characters: List<Char>) :
    RecyclerView.Adapter<LettersAdapter.CharactersViewsHolder>() {

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
            val action = LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(letter = character.toString())
            holder.button.findNavController().navigate(action)
        }
    }
}