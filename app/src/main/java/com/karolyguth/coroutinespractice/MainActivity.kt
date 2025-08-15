package com.karolyguth.coroutinespractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.karolyguth.coroutinespractice.assignments.coroutinebasics.BirdsScreen
import com.karolyguth.coroutinespractice.assignments.coroutinecontexts.ContextsScreen
import com.karolyguth.coroutinespractice.ui.theme.CoroutinesPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoroutinesPracticeTheme {
                ContextsScreen()
            }
        }
    }
}