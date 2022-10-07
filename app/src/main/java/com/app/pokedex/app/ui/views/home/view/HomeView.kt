package com.app.pokedex.app.ui.views.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.app.pokedex.app.ui.components.ButtonNavigation
import com.app.pokedex.app.ui.components.TitleText
import com.app.pokedex.app.ui.views.navigation.AppViewState

@Composable
fun HomeView(
    navController: NavHostController
) {
    val title = "Bienvenue dresseur"
    val name = "Jordan"
    val text = "Rechercher"

    Column() {
        TitleText(title = title, name = name)
        ButtonNavigation(navController = navController, text = text, route = AppViewState.ListView.route)
    }
}