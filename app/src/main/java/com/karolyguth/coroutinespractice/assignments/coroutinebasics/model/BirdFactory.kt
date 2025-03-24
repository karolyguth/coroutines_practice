package com.karolyguth.coroutinespractice.assignments.coroutinebasics.model

object BirdFactory {
    fun createBird(ordialNumber: BirdOrdialNumber): Bird{
        return when(ordialNumber) {
            BirdOrdialNumber.FIRST -> Bird(
                number = BirdOrdialNumber.FIRST,
                name = "Tweety",
                sound = BirdSound.CAW
            )
            BirdOrdialNumber.SECOND -> Bird(
                number = BirdOrdialNumber.SECOND,
                name = "Zazu",
                sound = BirdSound.COO
            )
            BirdOrdialNumber.THIRD -> Bird(
                number = BirdOrdialNumber.THIRD,
                name = "Woodstock",
                sound = BirdSound.CHIRP
            )

        }
    }

}