package com.karolyguth.coroutinespractice.assignments.coroutinebasics.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.model.Bird
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.model.BirdOrdialNumber
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.model.BirdSound
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BirdSection(modifier: Modifier = Modifier, bird: Bird?) {

    LaunchedEffect(key1 = bird) {
        val job1 = launch {
            while (true) {
                bird?.number?.let { Log.d("BirdSection", it.name) }
                delay(1000)
            }
        }
        val job2 = launch {
            while (true) {
                bird?.name?.let { Log.d("BirdSection", it) }
                delay(1000)
            }
        }
    }

    Card(
        onClick = { },
        border = CardDefaults.outlinedCardBorder(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Row {
                Text(
                    text = "Bird:",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(bird?.name ?: "")
            }
            Row {
                Text(
                    text = "Sound:",
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(bird?.sound?.name ?: "")
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun BirdSectionPreview() {
    BirdSection(
        bird = Bird(
            number = BirdOrdialNumber.FIRST,
            name = "Bird 1",
            sound = BirdSound.CAW
        )
    )
}