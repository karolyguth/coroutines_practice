package com.karolyguth.coroutinespractice.assignments.coroutinebasics.model

object BirdFactory {
    fun createBird(ordialNumber: BirdOrdialNumber): Bird{
        return when(ordialNumber) {
            BirdOrdialNumber.FIRST -> Bird(
                number = BirdOrdialNumber.FIRST,
                name = "Bird 1",
                sound = BirdSound.CAW
            )
            BirdOrdialNumber.SECOND -> Bird(
                number = BirdOrdialNumber.SECOND,
                name = "Bird 2",
                sound = BirdSound.COO
            )
            BirdOrdialNumber.THIRD -> Bird(
                number = BirdOrdialNumber.THIRD,
                name = "Bird 3",
                sound = BirdSound.CHIRP
            )

        }
    }

}