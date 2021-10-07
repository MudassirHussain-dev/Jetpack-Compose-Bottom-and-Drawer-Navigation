package dev.hmh.jetpackcomposenavigation.navigation.bottum_nav

import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import dev.hmh.jetpackcomposenavigation.navigation.component.BottomNavigationBar
import dev.hmh.jetpackcomposenavigation.navigation.component.Dialog
import dev.hmh.jetpackcomposenavigation.navigation.drawer_nav.Drawer
import dev.hmh.jetpackcomposenavigation.navigation.drawer_nav.TopBar
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    darkMode: MutableState<Boolean>
) {
    val navController = rememberNavController()
    val navigationItem = listOf(
        Destinations.Screen1,
        Destinations.Screen2,
        Destinations.Screen3,
    )
    val scaffoldState =
        rememberScaffoldState(
            drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        )

    val scope = rememberCoroutineScope()
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigationBar(navController = navController, items = navigationItem)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
            }
        },
        isFloatingActionButtonDocked = false,
        floatingActionButtonPosition = FabPosition.End,
        topBar = {
            TopBar(
                scope = scope,
                scaffoldState = scaffoldState,
                openDialog = {
                    openDialog.value = true
                },
                displaySnackBar = {
                    scope.launch {
                        val snackbarState = scaffoldState.snackbarHostState.showSnackbar(
                            message = "snack bar",
                            duration = SnackbarDuration.Short,
                            actionLabel = "Accept"
                        )

                        when (snackbarState) {
                            SnackbarResult.ActionPerformed -> {
                                Log.d("sb", "MainScreen: Accept")
                            }
                            SnackbarResult.Dismissed -> {
                                Log.d("sb", "MainScreen: ignore")
                            }
                        }
                    }
                }

            )
        },
        drawerContent = {
            Drawer(
                scope = scope,
                scaffoldState = scaffoldState,
                navController = navController,
                items = navigationItem,

                )
        },
        drawerGesturesEnabled = false,

        ) {
        NavigationHost(navController, darkMode = darkMode)
    }
    Dialog(showDialog = openDialog.value, dismissDialog = { openDialog.value = false })
}