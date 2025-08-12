package com.karolyguth.coroutinespractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.lifecycle.lifecycleScope
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.presentation.CoroutineBasicsScreen
import com.karolyguth.coroutinespractice.sandbox.SandboxScreen
import com.karolyguth.coroutinespractice.ui.theme.CoroutinesPracticeTheme
import com.karolyguth.coroutinespractice.util.screens.CounterScreen
import com.karolyguth.coroutinespractice.util.screens.RotatingBoxScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Thread.sleep
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Timber.plant(Timber.DebugTree())

        setContent {
            CoroutinesPracticeTheme {
                SandboxScreen()
            }
        }
    }
}