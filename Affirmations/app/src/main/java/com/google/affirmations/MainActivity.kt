package com.google.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.affirmations.databinding.ActivityMainBinding
import com.google.affirmations.adapter.ItemAdapter
import com.google.affirmations.dataset.Affirmations

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = ItemAdapter(Affirmations.loadAffirmations())
    }
}