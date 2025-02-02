package com.maahiway.splitmymitrabill

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maahiway.splitmymitrabill.components.InputContainer
import com.maahiway.splitmymitrabill.components.TipContainer
import com.maahiway.splitmymitrabill.components.TopComponent
import com.maahiway.splitmymitrabill.ui.theme.SplitMyMitraBillTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val inputValue by remember { mutableStateOf("0") }
            MainContainer(inputValue)

        }
    }
}


@Composable
fun MainContainer(inputValue: String) {
    SplitMyMitraBillTheme {
        Scaffold(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
            content = { paddingValue ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(paddingValue),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Welcome to the Split My Mitra Bill App!",
                        modifier = Modifier.padding(20.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    TopComponent(inputValue)
                    MyInputCard(inputValue)
                }

            }
        )

    }
}

@Composable
fun MyInputCard(inputValue: String) {
    var input by remember { mutableStateOf(inputValue) }
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            InputContainer(input, onValueChanged = {
                input=it
            })
            TipContainer("32")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainContainer("200")
}

