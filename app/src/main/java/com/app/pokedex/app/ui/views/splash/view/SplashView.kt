package com.app.pokedex.app.ui.views.splash.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.pokedex.app.ui.views.splash.viewModels.SplashViewModel

@Composable
fun SplashView(splashVM: SplashViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = Unit, block ={
        splashVM.fetchSplashData()
    } )

    Text(text = "Loading ...")
}