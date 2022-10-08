package com.app.pokedex.app.models

data class ResultPokemonDTO (
    val name: String,
    val height : Number,
    val sprites : Sprites
) {
    data class Sprites (
        val front_default : String,
        val front_shiny : String
    )
}