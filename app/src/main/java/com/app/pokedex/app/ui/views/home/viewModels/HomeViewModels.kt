package com.app.pokedex.app.ui.views.home.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.pokedex.app.common.api.AppService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModels @Inject constructor(
    private val appService: AppService
) : ViewModel() {
    private val _dresseur: MutableStateFlow<String> = MutableStateFlow("")
    val dresseur: StateFlow<String> = _dresseur.asStateFlow()

    init {
        viewModelScope.launch {
            _dresseur.value = appService.getDresseurName()?: ""
        }
    }
}