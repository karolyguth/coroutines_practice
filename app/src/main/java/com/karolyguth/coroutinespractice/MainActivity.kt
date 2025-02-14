package com.karolyguth.coroutinespractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.karolyguth.coroutinespractice.ui.theme.CoroutinesPracticeTheme
import com.karolyguth.coroutinespractice.util.screens.CounterScreen
import com.karolyguth.coroutinespractice.util.screens.RotatingBoxScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        GlobalScope.launch(Dispatchers.Main) {
            delay(1000)
            sleep(5000)
        }

        setContent {
            CoroutinesPracticeTheme {
                RotatingBoxScreen()
            }
        }
    }
}
