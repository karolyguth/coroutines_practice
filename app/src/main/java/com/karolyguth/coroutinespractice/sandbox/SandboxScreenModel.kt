package com.karolyguth.coroutinespractice.sandbox

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class SandboxViewModel : ViewModel() {

    fun runTestCoroutines(onShowSnackbar: suspend (String) -> Unit) {
        viewModelScope.launch {
            val innerJob1 = launch {
                Timber.tag("innerJob1").d("Started innerJob1...")
                delay(1000)
                Timber.tag("innerJob1").d("Showing snackbar...")
                onShowSnackbar("Hello from innerJob1!")
                Timber.tag("innerJob1").d("Snackbar shown successfully.")
            }

            val innerJob2 = launch {
                Timber.tag("innerJob2").d("Started innerJob2...")
                delay(500)
                Timber.tag("innerJob2").d("innerJob2 finished.")
            }

            innerJob1.join()
            innerJob2.join()
            Timber.tag("SandboxVM").d("All inner jobs completed.")
        }
    }
}