package com.karolyguth.coroutinespractice.assignments.coroutinebasics.model

data class Bird(
    val number: BirdOrdialNumber,
    val name: String,
    val sound: BirdSound,
)

fun Bird.showOrdialNumberText() = when (number) {
    BirdOrdialNumber.FIRST -> "1st Bird"
    BirdOrdialNumber.SECOND -> "2nd Bird"
    BirdOrdialNumber.THIRD -> "3rd Bird"
}
