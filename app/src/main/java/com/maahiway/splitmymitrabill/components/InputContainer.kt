package com.maahiway.splitmymitrabill.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun InputContainer(inputValue: String, onValueChanged: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = inputValue,
            label = { Text("Enter Value::") },
            onValueChange = onValueChanged,
            keyboardActions = KeyboardActions {

            },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number)
        )
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
                    modifier = Modifier.wrapContentWidth(), onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add",
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text("1", modifier = Modifier.align(Alignment.CenterVertically))
                IconButton(
                    onClick = {},
                    modifier = Modifier.wrapContentWidth()
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Add",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}