package com.google.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        runApp()
    }

    private fun runApp() {
        binding.calculate.setOnClickListener {
            val cost = getCost()
            val tipPercentage = getTipPercentage()
            val roundUp = getRoundUp()
            showResult(cost, tipPercentage, roundUp)
        }
    }

    private fun getCost(): Double {
        return binding.costOfService.text.toString().toDoubleOrNull() ?: 0.0
    }

    private fun getTipPercentage(): Double {
        return when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radioAmazing -> 20.0
            R.id.radioGood -> 18.0
            else -> 15.0
        }
    }

    private fun getRoundUp(): Boolean {
        return binding.switchRoundUp.isChecked
    }

    private fun showResult(cost: Double, tipPercentage: Double, roundUp: Boolean) {
        var tip = (cost * tipPercentage) / 100
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        binding.tipAmount.text = getString(R.string.result, tip.toString())
    }
}