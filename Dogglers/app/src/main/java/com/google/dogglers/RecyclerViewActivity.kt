package com.google.dogglers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.dogglers.dataset.DataSet
import com.google.dogglers.adapter.DogCardAdapter
import com.google.dogglers.databinding.ActivityRecyclerBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewType = intent.getStringExtra(MyStrings.VIEW_TYPE)!!

        binding.recyclerView.adapter = DogCardAdapter(this, DataSet.dogs, viewType)
        showRecyclerView(viewType)
    }

    private fun showRecyclerView(viewType: String) {
        val layoutManager = when (viewType) {
            MyStrings.VERTICAL -> LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            MyStrings.HORIZONTAL -> LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            else -> GridLayoutManager(this, 2)
        }
        binding.recyclerView.layoutManager = layoutManager
    }
}