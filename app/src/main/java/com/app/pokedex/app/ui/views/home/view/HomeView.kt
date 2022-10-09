package com.app.pokedex.app.ui.views.home.view

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
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.pokedex.R
import com.app.pokedex.app.ui.views.home.viewModels.HomeViewModels

@Composable
fun HomeView(
    navController: NavHostController,
    HomeVM: HomeViewModels = hiltViewModel()
) {

    val title = "Bienvenue dresseur"
    val text = "Rechercher un pokemon"

    val dresseurName by HomeVM.dresseur.collectAsState()


    println("----------------SET----------------")
    println("---------------SET-----------------")
    println(dresseurName)
    println("--------------SET------------------")
    println("--------------SET------------------")

    Image(
        painter = painterResource(id = R.drawable.masterball),
        contentDescription = "masterball",
        modifier = Modifier.fillMaxSize()
    )

    Column() {
        TitleText(title = title, name = dresseurName)
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