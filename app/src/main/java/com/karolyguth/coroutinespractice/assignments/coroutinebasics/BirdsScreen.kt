package com.karolyguth.coroutinespractice.assignments.coroutinebasics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

@Composable
fun BirdsScreen(
    viewModel: SandboxViewModel = viewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val snackbarScope = remember { CoroutineScope(Dispatchers.Main) }

    var displayedBird by remember { mutableStateOf(Bird.CHIRP) }

    fun setDisplayedBird(bird: Bird) {
        displayedBird = bird
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding), contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Row(modifier = Modifier) {
                    Bird.entries.forEach { birdEntry ->
                        BirdButton(
                            modifier = Modifier, bird = birdEntry, setBird = {
                                setDisplayedBird(birdEntry)
                            })
                    }

                }
                BirdBox(modifier = Modifier, bird = displayedBird)

            }
        }
    }
}

@Composable
fun BirdButton(modifier: Modifier, bird: Bird, setBird: (Bird) -> Unit) {
    Button(modifier = modifier, onClick = {
        setBird(bird)
    }) { Text(bird.name) }
}


@Composable
fun BirdBox(modifier: Modifier, bird: Bird) {
    LaunchedEffect(bird) {
        when (bird) {
            Bird.COO -> {
                launch {
                    while (true) {
                        delay(1000)
                        Timber.tag("BIRD").d("COO")
                    }

                }
            }

            Bird.CAW -> {
                launch {
                    while (true) {
                        delay(1000)
                        Timber.tag("BIRD").d("CAW")
                    }
                }

            }

            Bird.CHIRP -> {
                launch {

                    while (true) {
                        delay(1000)
                        Timber.tag("BIRD").d("CHIRP")
                    }
                }
            }
        }
    }

    Box(
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
            .border(border = BorderStroke(width = 1.dp, color = Color.Black)),
        contentAlignment = Alignment.Center
    ) {
        Text(bird.name)
    }
}

enum class Bird {
    COO, CAW, CHIRP
}