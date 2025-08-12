package com.karolyguth.coroutinespractice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.DelicateCoroutinesApi

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun SnackbarScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()


    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }

    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding), contentAlignment = Alignment.Center) {

        }
    }
}