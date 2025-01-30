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
            MainContainer()

        }
    }
}


@Composable
fun MainContainer() {
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
                    TopComponent("200$")
                    MyInputCard()
                }

            }
        )

    }
}

@Composable
fun MyInputCard() {
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            InputContainer("test") { }
            TipContainer()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainContainer()
}

