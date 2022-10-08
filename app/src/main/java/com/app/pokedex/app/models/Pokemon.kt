package com.app.pokedex.app.models

data class ResultPokemonDTO (
    val id : Number,
    val name: String,
    val height : Number,
    val weight : Number,
    val sprites : Sprites,
    val types : List<Types>,
    val stats : List<Stats>,
    val abilities : List<Abilities>
) {

    data class Sprites (
        val front_default : String,
        val front_shiny : String,
    )

    data class Types (
        val slot : Number,
        val type : TypeDetails
    ) {
        data class TypeDetails (
            val name : String,
            val url : String
        )
    }

    data class Stats (
        val base_stat : Number
    )

    data class Abilities (
        val ability : Ability,
        val is_hidden : Boolean
    ) {
        data class Ability (
            val name : String
        )
    }

}