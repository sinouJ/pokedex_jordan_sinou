package com.app.pokedex.app.ui.views.list.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun ListView(
    navController: NavHostController
) {
    Column() {
        Text("List")
    }
}