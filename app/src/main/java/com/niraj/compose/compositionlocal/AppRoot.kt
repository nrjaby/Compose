package com.niraj.compose.compositionlocal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Composable
fun AppRoot( ) {

    // Mock data
    val currentUser = remember { User(id = "12345", name = "Niraj Singh") }
    val appTheme = remember { AppTheme(primaryColor = Color(0xFF6200EA), secondaryColor = Color(0xFF03DAC5)) }

    CompositionLocalProvider(
        LocalUser provides currentUser,
        LocalAppTheme provides appTheme
    ) {
        AppScreen()
    }
}