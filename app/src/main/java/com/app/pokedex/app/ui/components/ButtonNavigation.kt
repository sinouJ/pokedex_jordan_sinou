package com.app.pokedex.app.ui.components


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ButtonNavigation(navController: NavHostController, text: String, route: String) {
    Row(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Button(onClick = {
            navController
                .navigate(route)
        }) {
            Text(text = text)
        }
    }
}