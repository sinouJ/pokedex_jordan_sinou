package com.app.pokedex.app.ui.views.splash.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.pokedex.app.services.appData.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val userService: UserService): ViewModel() {

    val authState = userService.authState

    fun fetchSplashData() {
        viewModelScope.launch {
            userService.isLoaded()
        }
    }

}