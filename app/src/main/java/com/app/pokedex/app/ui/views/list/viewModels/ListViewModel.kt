package com.app.pokedex.app.ui.views.list.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.pokedex.app.common.api.AppService
import com.app.pokedex.app.models.ResultPokemons
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val appService: AppService
) : ViewModel() {

    private val _pokemons: MutableStateFlow<List<ResultPokemons.PokemonDTO>> = MutableStateFlow(emptyList())
    val pokemons: StateFlow<List<ResultPokemons.PokemonDTO>> = _pokemons.asStateFlow()

    init {
        viewModelScope.launch {
            _pokemons.value = appService.fetchPokemons()?.results ?: emptyList()
        }
    }
}