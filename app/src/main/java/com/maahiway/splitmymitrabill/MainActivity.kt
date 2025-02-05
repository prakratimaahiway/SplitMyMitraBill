package com.maahiway.splitmymitrabill

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maahiway.splitmymitrabill.components.BillForm
import com.maahiway.splitmymitrabill.components.TopHeader
import com.maahiway.splitmymitrabill.ui.theme.SplitMyMitraBillTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val inputValue by remember { mutableStateOf("123") }
            MainContainer(inputValue)
            { billAmt->
               Log.d("TAG","Bill Amt->$billAmt")

            }

        }
    }
}


@Composable
fun MainContainer(inputValue: String, onValChanged:(String)->Unit) {

    val totalBillAmt = remember {
        mutableDoubleStateOf(0.0)
    }
    val splitByState = remember {
        mutableIntStateOf(1)
    }
    val range = IntRange(start = 1, endInclusive = 100)
    val totalPerPerson = remember {
        mutableDoubleStateOf(0.0)
    }
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
                        "Welcome to the SplitMyMitra Bill App!",
                        modifier = Modifier.padding(20.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    TopHeader(totalPerPerson)
                    BillForm(range,splitByState,totalBillAmt,totalPerPerson)
                    {
                        Log.d("TESSS>>",inputValue)
                    }
                }

            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainContainer("200"){}
}

