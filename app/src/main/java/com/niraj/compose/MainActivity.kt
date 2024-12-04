package com.niraj.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.niraj.compose.side_effect.ParentComposable
import com.niraj.compose.side_effect.RememberCoroutineScope
import com.niraj.compose.state.ParentRememberUpdatedState
import com.niraj.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTheme {

            }
        }
    }
}
