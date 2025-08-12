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

        val threads = hashMapOf<Long, String>()
        val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(100) {
                launch {
                    threads[Thread.currentThread().id] = Thread.currentThread().name
                    Thread.sleep(1000)
                }
            }
        }

        fun testCoroutines(snackbarHostState: SnackbarHostState) {
            lifecycleScope.launch {
                val innerJob1 = launch {
                    Timber.tag("innerJob1").d("Started innerJob1...")
                    delay(1000)
                    Timber.tag("innerJob1").d("Showing snackbar...")
                    snackbarHostState.showSnackbar("Hello from innerJob1!")
                    Timber.tag("innerJob1").d("Snackbar shown successfully.")
                }

                val innerJob2 = launch {
                    Timber.tag("innerJob2").d("Started innerJob2...")
                    delay(500)
                    Timber.tag("innerJob2").d("innerJob2 finished.")
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
                val snackbarHostState = remember { SnackbarHostState() }
                Scaffold(
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { padding ->
                    Box(
                        modifier = Modifier.fillMaxSize().padding(padding),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = { testCoroutines(snackbarHostState) }) {
                            Text("Run")
                        }
                    }
                }
            }
        }
    }
}
