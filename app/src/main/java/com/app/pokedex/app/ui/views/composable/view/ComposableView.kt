package com.app.pokedex.app.ui.views.composable.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.pokedex.app.services.appData.UserService
import com.app.pokedex.app.ui.views.composable.viewModels.ComposableViewModel
import com.app.pokedex.app.ui.views.navigation.AppControllerView
import com.app.pokedex.app.ui.views.splash.view.SplashView

@Composable
fun ComposableView(composableVM: ComposableViewModel = hiltViewModel()) {
    val authState by composableVM.authState.observeAsState()

    when (authState) {
        UserService.AuthState.Splash -> SplashView()
        UserService.AuthState.Loaded -> AppControllerView()
        null -> SplashView() // TODO: ErrorView()
    }
}
