package com.karolyguth.coroutinespractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.karolyguth.coroutinespractice.sandbox.SandboxScreen
import com.karolyguth.coroutinespractice.ui.theme.CoroutinesPracticeTheme
import timber.log.Timber

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