package com.niraj.compose.state

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Composable() {
   var counter by remember {
       mutableIntStateOf( 0 )
   }

    Button(onClick = { counter ++ }) {
        Text(text = "Value increased")
    }
    
}