package dev.hmh.jetpackcomposenavigation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.hmh.jetpackcomposenavigation.navigation.bottum_nav.MainScreen
import dev.hmh.jetpackcomposenavigation.ui.theme.BLUE800
import dev.hmh.jetpackcomposenavigation.ui.theme.JetpackComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            val darkMode = remember { mutableStateOf(false) }

            SideEffect {
                systemUiController.setStatusBarColor(
                    color = BLUE800
                )
            }
            JetpackComposeNavigationTheme(darkTheme = darkMode.value) {
                // A surface container using the 'background' color from the theme

                MainScreen(darkMode = darkMode)
            }
        }
    }
}


@Preview(
    showBackground = true,
    name = "MudassirDev",
    showSystemUi = true,
    device = Devices.DEFAULT,

    )
@Composable
fun DefaultPreview() {
    JetpackComposeNavigationTheme {
        TEB()
    }
}