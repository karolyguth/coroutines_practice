package com.karolyguth.coroutinespractice

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun CounterScreen(modifier: Modifier = Modifier) {

    var selectedBird: Bird by remember { mutableStateOf(Bird("Bird 1", "Chirp")) }

    LaunchedEffect(key1 = selectedBird) {

        while (true) {
            delay(1000)
            Log.d(selectedBird.name, selectedBird.sound)
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {


        BirdDisplay(
            modifier = Modifier,
            name = selectedBird.name,
            sound = selectedBird.sound
        )

        Row {
            Button(onClick = {
                selectedBird = Bird("Bird 1", "Chirp")
            }) {
                Text(text = "Chirp")
            }

            Button(onClick = {
                selectedBird = Bird("Bird 2", "Coo")
            }) {
                Text(text = "Coo")
            }

            Button(onClick = {
                selectedBird = Bird("Bird 3", "Caw")
            }) {
                Text(text = "Caw")
            }
        }
    }
}

@Composable
fun BirdDisplay(modifier: Modifier, name: String, sound: String) {

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = name)
    }
}

data class Bird(
    val name: String, val sound: String
)