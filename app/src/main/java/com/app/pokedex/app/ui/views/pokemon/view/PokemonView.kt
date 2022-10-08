package com.app.pokedex.app.ui.views.pokemon.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.app.pokedex.R
import com.app.pokedex.app.ui.views.pokemon.viewModels.PokemonViewModel

@Composable
fun PokemonView(
    PokemonVM: PokemonViewModel = hiltViewModel(),
    id: String
) {

    val pokemon by PokemonVM.pokemon.collectAsState()

    LaunchedEffect(PokemonVM) {
        PokemonVM.fetchPokemon(id)
    }
    println("-----------------------------------------------")
    println("-----------------------------------------------")
    println("-----------------------------------------------")
    println(pokemon)
    println("-----------------------------------------------")
    println("-----------------------------------------------")
    
    if (pokemon != null) {
        Row() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(R.color.teal_200))

            ) {
                AsyncImage(
                    model = pokemon!!.sprites.front_default,
                    contentDescription = "Pokemon illustration",
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(CenterHorizontally)
                )
            }
        }
        Row() {
            LazyColumn(
                modifier = Modifier.fillMaxHeight()
            ) {
                item {
                    Text(
                        text = pokemon!!.name,
                        style = MaterialTheme.typography.button,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp)
                    )
                    Text(
                        text = pokemon!!.height.toString()
                    )
                }
            }
        }
    }

}