package dev.hmh.jetpackcomposenavigation.navigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Screen1(
    naveToScreen2: (String) -> Unit
) {

    var textFieldValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Screen 1",
            style = TextStyle(color = Color.Blue, fontSize = 42.sp, fontWeight = FontWeight.Black)
        )
        TextField(
            value = textFieldValue,
            onValueChange = { it ->
                textFieldValue = it
            },
            label = { Text(text = "Enter Something") }
        )
        Button(onClick = { naveToScreen2(textFieldValue) }) {
            Text(text = "Screen2")
        }
    }
}