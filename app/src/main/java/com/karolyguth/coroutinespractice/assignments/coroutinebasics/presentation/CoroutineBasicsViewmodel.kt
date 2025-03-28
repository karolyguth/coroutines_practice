package com.karolyguth.coroutinespractice.assignments.coroutinebasics.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.model.Bird
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.model.BirdFactory
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.model.BirdOrdialNumber
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.model.BirdSound
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CoroutineBasicsViewmodel : ViewModel() {
    private val _state = MutableStateFlow(CoroutineBasicsScreenState())
    val state: StateFlow<CoroutineBasicsScreenState> = _state.asStateFlow()

    fun onBirdSelected(birdOrdialNumber: BirdOrdialNumber) {
            _state.update { currentState ->
                currentState.copy(selectedBird = when (birdOrdialNumber) {
                    BirdOrdialNumber.FIRST -> BirdFactory.createBird(BirdOrdialNumber.FIRST)
                    BirdOrdialNumber.SECOND -> BirdFactory.createBird(BirdOrdialNumber.SECOND)
                    BirdOrdialNumber.THIRD -> BirdFactory.createBird(BirdOrdialNumber.THIRD)
                })
            }
        }
}