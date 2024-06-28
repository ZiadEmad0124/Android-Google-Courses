package com.google.dessertclicker.model

import androidx.annotation.DrawableRes

data class Dessert(
    @DrawableRes val image: Int,
    val price: Int,
    val startProductionAmount: Int
)
