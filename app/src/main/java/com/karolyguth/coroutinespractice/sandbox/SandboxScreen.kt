package com.karolyguth.coroutinespractice.sandbox

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SandboxScreen(
    viewModel: SandboxViewModel = viewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val snackbarScope = remember { CoroutineScope(Dispatchers.Main) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    viewModel.runTestCoroutines { message ->
                        snackbarScope.launch {
                            snackbarHostState.showSnackbar(message)
                        }
                    }
                }
            ) {
                Text("Run")
            }
        }
    }
}