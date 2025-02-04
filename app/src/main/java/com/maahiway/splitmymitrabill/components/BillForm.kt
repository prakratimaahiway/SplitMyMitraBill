package com.maahiway.splitmymitrabill.components

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun BillForm(onValueChanged: (String) -> Unit) {
    val totalBillAmt = remember {
        mutableStateOf("")
    }
    Card(
        modifier = Modifier.padding(12.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = totalBillAmt.value,
                label = { Text("Enter Bill Amount:") },
                onValueChange = { totalBillAmt.value = it },
                keyboardActions = KeyboardActions(onDone = {
                    Log.d(TAG, "TESTER${totalBillAmt.value}")
                }),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Number
                )
            )
            TipContainer("23")
        }
    }
}


@Composable
fun TipContainer(totalTip: String) {
    val splitByState = remember {
        mutableStateOf(1)
    }
    val range = IntRange(start = 1, endInclusive = 100)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "Split", fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.weight(1f)
        ) {
            IconButton(
                modifier = Modifier.wrapContentWidth(), onClick = {
                  if(splitByState.value < range.last) {
                      splitByState.value += 1
                   }
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(24.dp)
                )
            }
            Text("${splitByState.value}", modifier = Modifier.align(Alignment.CenterVertically))
            IconButton(
                onClick = {
                    splitByState.value = if (splitByState.value > 1)
                        splitByState.value - 1
                    else
                        1
                },
                modifier = Modifier.wrapContentWidth()
            ) {
                Icon(
                    imageVector = Icons.Rounded.Clear,
                    contentDescription = "Remove",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
    val sliderValue = remember {
        mutableFloatStateOf(0f)
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text("Tip")
            Text(totalTip)
        }

        Column {

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
}