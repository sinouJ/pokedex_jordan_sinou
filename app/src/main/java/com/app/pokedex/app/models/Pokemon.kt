package com.app.pokedex.app.models

data class ResultPokemons(
    val count: Number,
    val results: List<PokemonDTO>
) {
    data class PokemonDTO (
        val name: String,
        val url: String
    )
}
