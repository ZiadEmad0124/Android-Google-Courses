package com.google.unscramble.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score

    private val _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    private val _currentScrambledWord = MutableLiveData<String>()
    val currentScrambledWord: LiveData<String>
        get() = _currentScrambledWord

    private val _status = MutableLiveData("Start")

    //    Start the Game
    fun startGame() {
        if (_status.value == "Start") {
            getNextWord()
            _status.value = "Running"
        }
    }

    //      Hold words which we used
    private var myWordsUsed: MutableList<String> = mutableListOf()

    //      Current word which we using now
    private lateinit var currentWord: String

    private fun getNextWord() {
        currentWord = Words.wordsList.random()

//        Change arrange of letters
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

//        Sometimes the arrange is the same
        while (String(tempWord).equals(currentWord, false))
            tempWord.shuffle()

//        Check if word has been used
        if (myWordsUsed.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord.value = String(tempWord)
            _currentWordCount.value = (_currentWordCount.value)?.inc()
            myWordsUsed.add(currentWord)
        }
    }

    //      To check number of used words
    fun nextWord(): Boolean {
        return if (_currentWordCount.value!! < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else {
            false
        }
    }

    //       Increase the score if the answer was right
    private fun increaseScore() {
        _score.value = (_score.value)?.plus(SCORE_INCREASE)
    }

    //       Check if the answer was correct
    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    //        if word count reached to max value reset game
    fun reinitializeData() {
        _score.value = 0
        _currentWordCount.value = 0
        myWordsUsed.clear()
        getNextWord()
    }
}