package com.google.affirmations.dataset

import com.google.affirmations.R
import com.google.affirmations.model.Affirmation

class Affirmations {

    companion object{
        fun loadAffirmations(): List<Affirmation> {
            return listOf(
                Affirmation("I am strong", R.drawable.image1),
                Affirmation("I believe in myself", R.drawable.image2),
                Affirmation("Each day is a new opportunity to grow and be a better version of myself", R.drawable.image3),
                Affirmation("Every Challenge in my life is an opportunity to learn from", R.drawable.image4),
                Affirmation("I have so much to be grateful for", R.drawable.image5),
                Affirmation("Good things are always coming into my life", R.drawable.image6),
                Affirmation("New Opportunities await me at every turn", R.drawable.image7),
                Affirmation("I have the courage to follow my heart", R.drawable.image8),
                Affirmation("Things will unfold at precisely the right time", R.drawable.image9),
                Affirmation("I will be present in all the moment that this day brings", R.drawable.image10)
            )
        }
    }
}
