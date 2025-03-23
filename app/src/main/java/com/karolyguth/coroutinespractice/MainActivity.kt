package com.karolyguth.coroutinespractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.presentation.CoroutineBasicsScreen
import com.karolyguth.coroutinespractice.ui.theme.CoroutinesPracticeTheme
import com.karolyguth.coroutinespractice.util.screens.CounterScreen
import com.karolyguth.coroutinespractice.util.screens.RotatingBoxScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Thread.sleep
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val threads = hashMapOf<Long, String>()
        val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(100) {
                launch {
                    threads[Thread.currentThread().id] = Thread.currentThread().name
                    Thread.sleep(1000)
                }
            }
        }

        GlobalScope.launch {
            val timeMilis = measureTimeMillis {
                job.join()
            }
            println("Launched ${threads.size} threads in $timeMilis ms")
        }


        setContent {
            CoroutinesPracticeTheme {
                CoroutineBasicsScreen()
            }
        }
    }
}
