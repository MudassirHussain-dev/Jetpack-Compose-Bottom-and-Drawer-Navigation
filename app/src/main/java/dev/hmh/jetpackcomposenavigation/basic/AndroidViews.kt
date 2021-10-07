package dev.hmh.jetpackcomposenavigation.basic


import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import dev.hmh.jetpackcomposenavigation.R

@Composable
fun AndroidView() {
    AndroidView(
        modifier = Modifier.fillMaxWidth(),
        factory = {
            TextView(it).apply {
                textSize = 19f
                setText(R.string.app_name)
            }
        }
    ) {

    }
}