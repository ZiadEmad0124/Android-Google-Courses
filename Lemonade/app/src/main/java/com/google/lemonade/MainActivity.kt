package com.google.lemonade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    private var currentStatus: Status = Status.SELECT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        imageView = findViewById(R.id.imageView)

        clickLemonImage()
    }

    private fun clickLemonImage() {
        imageView.setOnClickListener {
            changeStatus()
            setViewElements(currentStatus)
        }

        imageView.setOnLongClickListener {
            Snackbar.make(it, currentStatus.toString(), Snackbar.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    private fun changeStatus() {
        currentStatus = when (currentStatus) {
            Status.SELECT -> {
                Status.SQUEEZE
            }

            Status.SQUEEZE -> {
                Status.DRINK
            }

            Status.DRINK -> {
                Status.RESTART
            }

            Status.RESTART -> {
                Status.SELECT
            }
        }
    }

    private fun setViewElements(status: Status) {
        imageView.setImageResource(status.image)
        textView.text = getString(status.text)
    }

    enum class Status(val image: Int, val text: Int) {
        SELECT(R.drawable.lemon_tree, R.string.click_to_select_a_lemon),
        SQUEEZE(R.drawable.lemon_squeeze, R.string.click_to_juice_the_lemon),
        DRINK(R.drawable.lemon_drink, R.string.click_to_drink_your_lemonade),
        RESTART(R.drawable.lemon_restart, R.string.click_to_start_again)
    }
}