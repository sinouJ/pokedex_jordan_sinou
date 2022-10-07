package com.app.pokedex.app.ui.views.list.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.pokedex.app.ui.views.list.viewModels.ListViewModel

@Composable
fun ListView(
    ListVM: ListViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val pokemons by ListVM.pokemons.collectAsState()

    Column() {
        Text("List")

        LazyColumn() {
            pokemons.forEach {
                item {
                    Text(text = it.name)
                    Text(text = it.url)
                }
            }
        }
    }
}