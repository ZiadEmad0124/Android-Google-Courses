package com.google.diceroller

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class  ExampleUnitTest {
    @Test
    fun generatesNumber() {
        val num = Dice.roll()
        assertTrue("The value wasn't between 1 & 6",num in 1..6)
    }
}