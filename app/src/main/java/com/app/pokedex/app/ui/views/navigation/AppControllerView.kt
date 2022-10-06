package com.app.pokedex.app.ui.views.navigation

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.People
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.pokedex.app.ui.views.home.view.HomeView
import com.app.pokedex.app.ui.views.list.view.ListView

sealed class AppViewState(val route: String, val name: String, var icon: ImageVector, val iconSelected: ImageVector) {
    object HomeView : AppViewState("home", name = "Home", Icons.Filled.Home, Icons.Outlined.Home)
    object ListView : AppViewState("list", name = "Pokemon list", Icons.Outlined.People, Icons.Default.People)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppControllerView() {

    val navController = rememberNavController()
    val currentRoute = remember {
        mutableStateOf(AppViewState.HomeView.route)
        mutableStateOf(AppViewState.ListView.route)
    }

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, _, _ ->
            currentRoute.value = navController.currentBackStackEntry?.destination?.route ?: AppViewState.HomeView.route
        }
    }

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, _, _ ->
            currentRoute.value = navController.currentBackStackEntry?.destination?.route ?: AppViewState.HomeView.route
        }
    }
    Scaffold(
        bottomBar = {
            AppBottomBar(navController)
        }
    ) {
        NavHost(navController = navController, startDestination = AppViewState.HomeView.route) {
            composable(AppViewState.HomeView.route) {
                HomeView(navController = navController)
            }
            
            composable(AppViewState.ListView.route) {
                ListView(navController = navController)
            }

            //composable(
            //    AppViewState.ListView.route + "{id}"
            //) { backStackEntry ->
            //    backStackEntry.arguments?.getString("id")?.let { it1 -> CharacterView(id = it1) }
            //}
        }
    }

}
