package com.niraj.compose.side_effect

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

@Composable
fun LaunchedEffectWithUpdatedState(
    timerSeconds: Int,
    onTimeout: () -> Unit
) {

    val currentOnTimeout by rememberUpdatedState(newValue = onTimeout)

    var secondsLeft by remember { mutableStateOf(timerSeconds) }

    LaunchedEffect(timerSeconds) {
        while (secondsLeft > 0) {
            delay(1000L)
            secondsLeft--
        }
        currentOnTimeout()
    }

    Text(text = "Seconds left: $secondsLeft", style = MaterialTheme.typography.bodyMedium)
}

@Composable
fun ParentComposable() {
    var showMessage by remember { mutableStateOf(false) }

    LaunchedEffectWithUpdatedState(
        timerSeconds = 5,
        onTimeout = { showMessage = true }
    )

    if (showMessage) {
        Text("Time's up!", style = MaterialTheme.typography.bodyMedium)
    }
}
