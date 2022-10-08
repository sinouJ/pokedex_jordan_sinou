package com.app.pokedex.app.ui.views.home.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.app.pokedex.app.ui.components.ButtonNavigation
import com.app.pokedex.app.ui.components.TitleText
import com.app.pokedex.app.ui.views.navigation.AppViewState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import com.app.pokedex.R

@Composable
fun HomeView(
    navController: NavHostController,
    name: String
) {

    val title = "Bienvenue dresseur"
    val text = "Rechercher un pokemon"

    Image(
        painter = painterResource(id = R.drawable.masterball),
        contentDescription = "masterball",
        modifier = Modifier.fillMaxSize()
    )

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