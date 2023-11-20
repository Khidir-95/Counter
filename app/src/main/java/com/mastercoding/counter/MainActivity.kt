package com.mastercoding.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mastercoding.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterIncrease()
                }
            }
        }
    }
}

@Composable
fun CounterIncrease(modifier: Modifier = Modifier){
    var count by remember {
        mutableStateOf(0)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        ) {
        Text(text = count.toString(), fontSize = 100.sp)
        Spacer(modifier = modifier.height(16.dp))
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement =Arrangement.SpaceEvenly
            ) {
            Button(onClick = {count++}) {
                Text(text = "Increase",
                    fontSize = 10.sp)
            }
            Button(onClick = {count--}) {
                Text(text = "Decrease",
                    fontSize = 10.sp)
            }
            Button(onClick = {count=0}) {
                Text(text = "Reset",
                    fontSize = 10.sp)
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CounterTheme {
        CounterIncrease()
    }
}