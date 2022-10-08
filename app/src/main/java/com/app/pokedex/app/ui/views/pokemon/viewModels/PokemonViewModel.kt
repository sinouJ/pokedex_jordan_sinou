package com.app.pokedex.app.ui.views.pokemon.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.pokedex.app.common.api.AppService
import com.app.pokedex.app.models.ResultPokemonDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val appService : AppService
) : ViewModel() {

    private val _pokemon: MutableStateFlow<ResultPokemonDTO?> = MutableStateFlow(null)
    val pokemon: StateFlow<ResultPokemonDTO?> = _pokemon.asStateFlow()

    fun fetchPokemon(id: String) {
        viewModelScope.launch {
            _pokemon.value = appService.fetchPokemon("$id")
        }
    }
}