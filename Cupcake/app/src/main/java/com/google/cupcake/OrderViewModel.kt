package com.google.cupcake

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private const val PRICE_PER_CUPCAKE = 2.00
private const val PRICE_PER_SAME_DAY_CUPCAKE = 3.00

class OrderViewModel : ViewModel() {

    private var _quantity: MutableLiveData<Int> = MutableLiveData()
    val quantity get() = _quantity
    fun setQuantity(numberCupcakes: Int) {
        _quantity.value = numberCupcakes
        updatePrice()
    }

    private var _flavor: MutableLiveData<String> = MutableLiveData()
    val flavor get() = _flavor
    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    private var _date: MutableLiveData<String> = MutableLiveData()
    val date get() = _date
    fun setDate(pickupDate: String) {
        _date.value = pickupDate
        updatePrice()
    }

    private var _price: MutableLiveData<Double> = MutableLiveData()
    val price get() = _price

    private var _status: MutableLiveData<String> = MutableLiveData("Start")

    fun startOrder() {
        if (_status.value == "Start") {
            resetOrder()
            _status.value = "Running"
        }
    }

    fun hasNoFlavorSet(): Boolean {
        return _flavor.value.isNullOrEmpty()
    }

    private fun getPickUpOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }

    val dataOption = getPickUpOptions()

    fun resetOrder() {
        _quantity.value = 0
        _flavor.value = ""
        _date.value = dataOption[3]
        _price.value = 0.0
    }

    private fun updatePrice() {
        _price.value = (quantity.value ?: 0) * PRICE_PER_CUPCAKE
        if (_date.value == dataOption[0]) {
            _price.value = (_price.value)?.plus(PRICE_PER_SAME_DAY_CUPCAKE)
        }
    }
}