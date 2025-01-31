package com.maahiway.splitmymitrabill.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TipContainer() {
    val sliderValue = remember {
        mutableFloatStateOf(0f)
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("33%")
        Slider(
            value = sliderValue.floatValue,
            onValueChange = { newValue ->
                sliderValue.floatValue = newValue
            },
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Blue,
                inactiveTrackColor = Color.Gray
            ),
            enabled = true
        )
    }
}