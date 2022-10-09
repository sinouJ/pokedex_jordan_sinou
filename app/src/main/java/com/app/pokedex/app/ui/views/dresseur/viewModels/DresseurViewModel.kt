package com.app.pokedex.app.ui.views.dresseur.viewModels

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
class DresseurViewModel @Inject constructor(
    private val appService: AppService
) : ViewModel() {

    fun dresseurName(name: String) {
        viewModelScope.launch {
            appService.dresseurName(name)
        }
    }
}