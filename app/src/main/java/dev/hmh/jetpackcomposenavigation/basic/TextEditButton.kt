package dev.hmh.jetpackcomposenavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TEB() {

    var textFieldValue by remember { mutableStateOf("") }
    var textValue by remember { mutableStateOf("text value....") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "bg",
            contentScale = ContentScale.FillWidth
        )

        Text(
            text = textValue,
            style = TextStyle(
                color = Color.Green,
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        )

        TextField(
            value = textFieldValue,
            onValueChange = { tex ->
                textFieldValue = tex

            },
            label = {
                Text(text = "Write something")
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_icon),
                    contentDescription = "icon",
                )
            }

        )

        Button(onClick = {
            textValue = textFieldValue
        }
        ) {
            Text(text = "Click Me")
        }
    }
}