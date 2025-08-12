package com.karolyguth.coroutinespractice.assignments.coroutinebasics.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.model.BirdOrdialNumber
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.presentation.components.BirdSection

@Composable
fun CoroutineBasicsScreen(coroutineBasicsViewmodel: CoroutineBasicsViewmodel = viewModel()) {
    val state by coroutineBasicsViewmodel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        BirdSection(bird = state.selectedBird)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                )
        ) {
            Button(onClick = {
                coroutineBasicsViewmodel.onBirdSelected(BirdOrdialNumber.FIRST)
            }, content = {
                Text("1st Bird")
            })

            Button(onClick = {
                coroutineBasicsViewmodel.onBirdSelected(BirdOrdialNumber.SECOND)
            }, content = {
                Text("2nd Bird")
            })

            Button(onClick = {
                coroutineBasicsViewmodel.onBirdSelected(BirdOrdialNumber.THIRD)
            }, content = {
                Text("3rd Bird")
            })
        }
    }
}


@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun CoroutineBasicsScreenPreview(
) {
    CoroutineBasicsScreen()
}