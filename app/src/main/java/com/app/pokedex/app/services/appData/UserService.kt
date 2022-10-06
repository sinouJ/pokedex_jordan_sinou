package com.app.pokedex.app.services.appData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.pokedex.app.common.api.AppService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService @Inject constructor(
    private val appService: AppService
) {

    enum class AuthState {
        Splash,
        Loaded
    }

    private val _authState: MutableLiveData<AuthState> = MutableLiveData(AuthState.Splash)
    val authState: LiveData<AuthState> = _authState

    fun isLoaded() {
//        val response = appService.fetchCharacters()
//        println(response)
//        if (response != null) {
//            _authState.postValue(AuthState.Loaded)
//        }
        _authState.postValue(AuthState.Loaded)
    }
}