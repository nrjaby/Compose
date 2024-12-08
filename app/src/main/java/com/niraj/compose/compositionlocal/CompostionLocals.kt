package com.niraj.compose.compositionlocal

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalUser = compositionLocalOf<User?> { null }

val LocalAppTheme = staticCompositionLocalOf<AppTheme> {
    error("No default AppTheme provided!")
}

data class User(val id: String, val name: String)
data class AppTheme(val primaryColor: Color, val secondaryColor: Color)
