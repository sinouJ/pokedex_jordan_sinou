package com.app.pokedex.app.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonNavigation(navController: NavHostController, text: String, route: String) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = CenterHorizontally
    ) {
        Button(
            onClick = {
                navController
                    .navigate(route)
            },
        ) {
            Text(
                text = text,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}