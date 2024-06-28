package com.google.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.dogglers.MyStrings
import com.google.dogglers.model.Dog
import com.google.dogglers.R

class DogCardAdapter(
    private val context: Context,
    private val dogs: List<Dog>,
    private val viewType: String
) : RecyclerView.Adapter<DogCardAdapter.ViewsHolder>() {

    class ViewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val picture: ImageView = itemView.findViewById(R.id.pictureView)
        val name: TextView = itemView.findViewById(R.id.nameView)
        val age: TextView = itemView.findViewById(R.id.ageView)
        val hobbies: TextView = itemView.findViewById(R.id.hobbiesView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewsHolder {
        val myLayout = when (this.viewType) {
            MyStrings.VERTICAL, MyStrings.HORIZONTAL -> R.layout.horizontal_vertical_item_view
            else -> R.layout.grid_item_view
        }
        return ViewsHolder(LayoutInflater.from(parent.context).inflate(myLayout, parent, false))
    }

    override fun getItemCount(): Int {
        return dogs.size
    }

    override fun onBindViewHolder(holder: ViewsHolder, position: Int) {
        val dog = dogs[position]
        holder.picture.setImageResource(dog.picture)
        holder.name.text = dog.name
        holder.age.text = context.getString(R.string.age, dog.age)
        holder.hobbies.text = context.getString(R.string.hobbies, dog.hobbies)
    }
}