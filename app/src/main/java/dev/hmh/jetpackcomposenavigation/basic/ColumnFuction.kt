package dev.hmh.jetpackcomposenavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Increment() {
    Column {
        var num by rememberSaveable { mutableStateOf(0) }
        Text(text = "$num")

        Divider(thickness = 20.dp, color = Color.Transparent)
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Counter(
                btnTitle = "Increment",
                updateCounter = {
                    num++
                }
            )
            Counter(
                btnTitle = "de-crement",
                updateCounter = {
                    num--
                }
            )
        }

    }
}

@Composable
fun Counter(
    btnTitle: String,
    updateCounter: () -> Unit
) {
    Button(onClick = { updateCounter() }) {
        Text(text = btnTitle)
    }
}