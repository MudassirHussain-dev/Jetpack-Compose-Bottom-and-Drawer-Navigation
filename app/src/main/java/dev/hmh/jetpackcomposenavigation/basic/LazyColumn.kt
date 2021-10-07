package dev.hmh.jetpackcomposenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyColumn() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "HMh", style = TextStyle(
                    color = Color.Blue,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black
                )
            )
        }

        /* items(listaProductsto) {
             ProductCom(it)
         }*/
        itemsIndexed(listaProductsto) { position, producto ->
            if (position % 5 == 0 && position != 0) {
                LazyRow {
                    items(listaTitle) {
                        TitleCom(it)
                    }
                }
            } else {
                ProductCom(products = producto)
            }
        }
    }
}


@Composable
fun ProductCom(products: Products) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = products.number, style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
            )
        )
        Text(
            text = "${products.price}.00 MXN", style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
        )
    }

}

@Composable
fun TitleCom(title: Title) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .size(140.dp)
            .clip(RoundedCornerShape(12))
            .background(color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title.title, style = TextStyle(
                fontWeight = FontWeight.Black
            )
        )
    }
}

data class Products(
    val number: String,
    val price: Double,
)

data class Title(
    val title: String,
)

private val listaProductsto = listOf(
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
    Products(number = "HMH", price = 18.00),
)

private val listaTitle = listOf(
    Title(title = "Title 1"),
    Title(title = "Title 1"),
    Title(title = "Title 1"),
    Title(title = "Title 1"),
    Title(title = "Title 1"),
)
