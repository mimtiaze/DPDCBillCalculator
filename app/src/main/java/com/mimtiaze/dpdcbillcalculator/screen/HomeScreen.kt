package com.mimtiaze.dpdcbillcalculator.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen() {
    val TAG = "HomeScreen"

    val homeScreenViewModel : HomeScreenViewModel = viewModel()
    var previousReading by rememberSaveable { mutableStateOf(homeScreenViewModel.previousReading) }
    var currentReading by rememberSaveable { mutableStateOf(homeScreenViewModel.currentReading) }
    
    Column {
        ReadingRow(title = "Previous Reading",
            previousReading,
            onValueChanged = {
                previousReading = it
                Log.d(TAG, "previousReading = $previousReading")
            }
        )
        ReadingRow(title = "Current Reading",
            currentReading,
            onValueChanged = {
                currentReading = it
                Log.d(TAG, "currentReading = $currentReading")
            }
        )

        Button( onClick = {
            homeScreenViewModel.previousReading = previousReading
            homeScreenViewModel.currentReading = currentReading
            Log.d(TAG, "previousReading = ${homeScreenViewModel.previousReading}")
            Log.d(TAG, "currentReading = ${homeScreenViewModel.currentReading}")
        }) {

        }
    }
}

@Composable
fun ReadingRow(title: String, value: String, onValueChanged: (String) -> Unit) {
    Row {
        Text(text = title)
        TextField(value = value,
            onValueChange = onValueChanged,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}