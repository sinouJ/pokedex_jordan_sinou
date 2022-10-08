package com.app.pokedex.app.common.api

import com.app.pokedex.app.models.ResultPokemonDTO
import com.app.pokedex.app.models.ResultPokemons
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppService @Inject constructor() {

    private var apiService : ApiService = ApiService.getInstance()

    suspend fun fetchPokemons(): ResultPokemons? {
        println(callApiNoCatch { apiService.getPokemons() })
        return callApiNoCatch {
            apiService.getPokemons()
        }
    }

    suspend fun fetchPokemon(id : String): ResultPokemonDTO? {
        return callApiNoCatch {
            apiService.getPokemon(id,)
        }
    }
}