package com.niraj.compose.compositionlocal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        GreetingSection()
        UserActionsSection()
    }
}

@Composable
fun GreetingSection() {
    val user = LocalUser.current // Access current user
    val theme = LocalAppTheme.current // Access current theme

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(theme.primaryColor)
            .padding(16.dp)
    ) {
        Text(
            text = "Welcome, ${user?.name ?: "Guest"}!",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun UserActionsSection() {
    val user = LocalUser.current

    Column(modifier = Modifier.
        fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Text(
            text = "User ID: ${user?.id ?: "Unknown"}",
            style = MaterialTheme.typography.bodyMedium
        )

        Button(
            onClick = { /* Perform user action */ },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Perform Action")
        }
    }
}
