package com.google.dogglers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.dogglers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verticalButton.setOnClickListener {
            goToRecyclerView(MyStrings.VERTICAL)
        }

        binding.horizontalButton.setOnClickListener {
            goToRecyclerView(MyStrings.HORIZONTAL)
        }

        binding.gridButton.setOnClickListener {
            goToRecyclerView(MyStrings.GRID)
        }
    }

    private fun goToRecyclerView(viewType: String) {
        val intent = Intent(this, RecyclerViewActivity::class.java)
        intent.putExtra(MyStrings.VIEW_TYPE, viewType)
        startActivity(intent)
    }
}