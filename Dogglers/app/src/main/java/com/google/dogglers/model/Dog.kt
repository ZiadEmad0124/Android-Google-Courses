package com.google.dogglers.model

import androidx.annotation.DrawableRes

data class Dog(
    @DrawableRes val picture: Int,
    val name: String,
    val age: String,
    val hobbies: String
)