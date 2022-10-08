package com.app.pokedex.app.ui.views.list.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.pokedex.R
import com.app.pokedex.app.ui.components.RotateLoader
import com.app.pokedex.app.ui.components.TitleText
import com.app.pokedex.app.ui.views.list.viewModels.ListViewModel
import com.app.pokedex.app.ui.views.navigation.AppViewState

@Composable
fun ListView(
    ListVM: ListViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val pokemons by ListVM.pokemons.collectAsState()
    val titleText = "Les pokémon"

    Image(
        painter = painterResource(id = R.drawable.redball),
        contentDescription = "pokeball classique",
        modifier = Modifier.fillMaxSize()
    )

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        TitleText(title = titleText)

        var text by rememberSaveable { mutableStateOf("1") }

        Row(
            Modifier
                .padding(15.dp)
                .fillMaxWidth()) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("Rechercher un id de pokemon") }
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                navController
                    .navigate(AppViewState.PokemonView.route + text)
            }) {
                Text(text = "Search", style = MaterialTheme.typography.button)
            }
        }

        LazyColumn(
            Modifier.padding(15.dp)
        ) {
            if (pokemons.isNotEmpty()) {
                pokemons.forEach {
                    item {
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.button,
                            fontSize = 22.sp,
                            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp)
                        )
                        Text(
                            text = it.url,
                            style = MaterialTheme.typography.button
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
            else {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        RotateLoader()
                    }
                }
            }
        }
    }
}