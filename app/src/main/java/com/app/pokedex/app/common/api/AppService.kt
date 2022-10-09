package com.app.pokedex.app.common.api

import com.app.pokedex.app.models.ResultPokemonDTO
import com.app.pokedex.app.models.ResultPokemons
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppService @Inject constructor(

) {

    private var apiService : ApiService = ApiService.getInstance()

    private var dresseurName: String = ""

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

    suspend fun dresseurName(name: String) {
        dresseurName = name
        return
    }

    suspend fun getDresseurName(): String {
        println(dresseurName)
        return dresseurName
    }
}