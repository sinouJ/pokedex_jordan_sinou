package com.app.pokedex.app.ui.views.pokemon.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.app.pokedex.R
import com.app.pokedex.app.ui.views.pokemon.viewModels.PokemonViewModel

@Composable
fun PokemonView(
    PokemonVM: PokemonViewModel = hiltViewModel(),
    id: String,
    navController: NavHostController
) {

    val pokemon by PokemonVM.pokemon.collectAsState()

    LaunchedEffect(PokemonVM) {
        PokemonVM.fetchPokemon(id)
    }

    if (pokemon != null) {

        val weight = pokemon!!.weight.toDouble() / 10
        val height = pokemon!!.height.toDouble() / 10
        var pokemon_id = ""

        if(pokemon!!.id.toDouble() < 10) {
            println("less than 10")
            pokemon_id = "#00$id"
        }

        if(pokemon!!.id.toDouble() >= 10 && pokemon!!.id.toDouble() < 100) {
            println("between 10 and 100")
            pokemon_id = "#0$id"
        }

        if (pokemon!!.id.toDouble() >= 100) {
            println("more")
            pokemon_id = "#$id"
        }

        Column {
            Row {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color(R.color.teal_200))

                ) {
                    Button(
                        onClick = {
                            navController.navigate("list")
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0,0,0,0))
                    ) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "arrow back",
                        )
                    }
                    AsyncImage(
                        model = pokemon!!.sprites.front_default,
                        contentDescription = "Pokemon illustration",
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(CenterHorizontally)
                    )
                }
            }
            Row {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(10.dp, 15.dp)
                ) {
                    item {
                        Text(
                            text = pokemon!!.name,
                            style = MaterialTheme.typography.h3,
                            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 2.dp)
                        )

                        Text(
                            text = pokemon_id
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                    }

                    item {
                        Text(text = "Présentation", style = MaterialTheme.typography.h5)

                        Text(
                            text = height.toString()+"m"
                        )

                        Text(
                            text = weight.toString()+"kg"
                        )

                        pokemon!!.types.forEach {
                            Text(
                                text = it.type.name
                            )
                        }

                        pokemon!!.abilities.forEach {
                            Text(text = it.ability.name)
                            if (it.is_hidden) {
                                Text(text = "(hidden)" )
                            }
                            else {
                                Text(text = "(visible)")
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                    }

                    item {
                        Text(text = "Stats", style = MaterialTheme.typography.h5)

                        Text(
                            text = "HP: "+pokemon!!.stats[0].base_stat
                        )

                        Text(
                            text = "Attack: "+pokemon!!.stats[1].base_stat
                        )

                        Text(
                            text = "Defense: "+pokemon!!.stats[2].base_stat
                        )

                        Text(
                            text = "Special-attack: "+pokemon!!.stats[3].base_stat
                        )

                        Text(
                            text = "Special-defense: "+pokemon!!.stats[4].base_stat
                        )

                        Text(
                            text = "Speed: "+pokemon!!.stats[5].base_stat
                        )
                    }
                }
            }
        }
    }
}