package com.niraj.compose.side_effect

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter

@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var query by remember { mutableStateOf("") }

    // Use LaunchedEffect with snapshotFlow to observe query changes
    LaunchedEffect(query) {
        snapshotFlow { query }
            .debounce(300)
            .filter { it.isNotEmpty() } // Only search for non-empty queries
            .collect { searchQuery ->
                onSearch(searchQuery) // Perform search or API call
            }
    }

    TextField(
        value = query,
        onValueChange = { query = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Search...") }
    )
}