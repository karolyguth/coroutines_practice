package com.karolyguth.coroutinespractice.assignments.coroutinecontexts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.coroutineContext

class ContextsViewModel : ViewModel() {

    fun queryDatabase() {
        CoroutineScope(Dispatchers.Main + CoroutineName("QUERY COROUTINE")).launch {
            Timber.tag("CONTEXTS").d("dispatcher: ${coroutineContext[CoroutineDispatcher]},name: ${coroutineContext[CoroutineName]}")

            launch(Dispatchers.Default) {

            }
        }
    }
}