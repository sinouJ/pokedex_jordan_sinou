package com.app.pokedex.app.ui.views.dresseur.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DresseurView (
    navController: NavHostController
) {

    var name: String by rememberSaveable { mutableStateOf("") }

    Row(
    Modifier
    .padding(15.dp)
    .fillMaxWidth()) {
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = { Text("Quel est votre nom, dresseur ?") }
        )
        Spacer(modifier = Modifier.width(10.dp))
        Button(onClick = {
            navController.navigate("home" + name)
        }) {
            Text(text = "Valider", style = MaterialTheme.typography.button)
        }
    }
}