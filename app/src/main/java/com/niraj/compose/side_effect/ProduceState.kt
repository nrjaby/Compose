package com.niraj.compose.side_effect

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay

@Composable
fun ProduceState(userId: String) {

    val userProfile by produceState<UserProfile?>(
        initialValue = null,
        key1 = userId // Restart the coroutine when userId changes
    ) {
        value = fetchUserProfile(userId)
    }


    when (userProfile) {
        null -> { // Loading state
            CircularProgressIndicator()
        }
        else -> { // Data loaded
            Text(text = "Hello, ${userProfile?.name}!")
        }
    }
}

suspend fun fetchUserProfile(userId: String): UserProfile {
    delay(2000L)
    return UserProfile(name = "John Doe", userId = userId)
}

data class UserProfile(val name: String, val userId: String)
