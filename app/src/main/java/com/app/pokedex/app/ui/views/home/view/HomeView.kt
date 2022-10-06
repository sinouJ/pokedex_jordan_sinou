package com.app.pokedex.app.ui.views.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun HomeView(
    navController: NavHostController
) {
    Column() {
        Text("Home")
    }
}