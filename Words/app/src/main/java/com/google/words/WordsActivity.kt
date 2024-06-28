package com.google.words

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.words.dataset.DataSet
import com.google.words.adapter.WordsAdapter
import com.google.words.databinding.ActivityWordsBinding

class WordsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWordsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val character = intent.getCharExtra("character", 'A')

        val words: List<String> = DataSet.words.filter {
            it.startsWith(character, ignoreCase = true)
        }

        binding.recyclerView.adapter = WordsAdapter(this, words)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }
}