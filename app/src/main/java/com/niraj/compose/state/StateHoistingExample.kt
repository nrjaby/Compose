package com.niraj.compose.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ParentState() {
    var counter by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Counter(
            counter = counter,
            onCounterClick = { counter++ }
        )
    }

}

@Composable
fun Counter(
    counter: Int,
    onCounterClick: () -> Unit
) {
    Column {
        Text(text = "Counter : $counter")
        Button(onClick = onCounterClick) {
            Text(text = "Increased")
        }
    }

}