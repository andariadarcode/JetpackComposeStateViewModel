package com.andariadar.jetpackcomposestateviewmodel

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp(viewModel: MyAppViewModel = viewModel()) {
    val number: Int by viewModel.number.collectAsState()
    CounterContent(
        number = number,
        onNumberAdd = { viewModel.onNumberAdd() })
}

@Composable
fun CounterContent(
    number: Int,
    onNumberAdd: () -> Unit)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize())
    {
        Text(
            text = number.toString(),
            fontSize = 29.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(onClick = { onNumberAdd() }) {
            Text(text = "ADD")
        }
    }
}