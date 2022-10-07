package com.app.pokedex.app.ui.views.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.app.pokedex.app.ui.components.ButtonNavigation
import com.app.pokedex.app.ui.components.TitleText
import com.app.pokedex.app.ui.views.navigation.AppViewState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeView(
    navController: NavHostController
) {
    val title = "Bienvenue dresseur"
    val name = "Jordan"
    val text = "Rechercher un pokemon"

    Column() {
        TitleText(title = title, name = name)
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            ButtonNavigation(
                navController = navController,
                text = text,
                route = AppViewState.ListView.route,
            )
        }
    }
}