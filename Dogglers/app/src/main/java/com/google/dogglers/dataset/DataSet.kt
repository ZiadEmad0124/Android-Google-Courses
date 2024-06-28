package com.google.dogglers.dataset

import com.google.dogglers.R
import com.google.dogglers.model.Dog

class DataSet {

    companion object {
        val dogs = listOf(
            Dog(
                R.drawable.tzeitel,
                "Zeolite",
                "7",
                "sunbathing"
            ),
            Dog(
                R.drawable.leroy,
                "Leroy",
                "4",
                "sleeping in dangerous places"
            ),
            Dog(
                R.drawable.frankie,
                "Frankie",
                "2",
                "stealing socks"
            ),
            Dog(
                R.drawable.nox,
                "Nox",
                "8",
                "meeting new animals"
            ),
            Dog(
                R.drawable.faye,
                "Faye",
                "8",
                "Digging in the garden"
            ),
            Dog(
                R.drawable.bella,
                "Bella",
                "14",
                "Chasing sea foam"
            )
        )
    }
}