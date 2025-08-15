package com.karolyguth.coroutinespractice.assignments.coroutinebasics

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.coroutineContext

suspend fun queryDatabase() {
    val job = coroutineContext[Job]
    val name = coroutineContext[CoroutineName]

    println()
}