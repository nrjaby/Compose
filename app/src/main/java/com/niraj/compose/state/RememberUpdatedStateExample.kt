package com.niraj.compose.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay


@Composable
fun RememberUpdatedState(
    onTimeOut: () -> Unit
) {

    val currentTimeOut = rememberUpdatedState(onTimeOut)
    LaunchedEffect(Unit) {
        delay(3000L)
        currentTimeOut.value()
    }
}

@Composable
fun ParentRememberUpdatedState() {

    var currentMessage by remember { mutableStateOf("Waiting time..") }
    RememberUpdatedState(
        onTimeOut = { currentMessage = "Time Up !!" }
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = currentMessage)
    }
}