package com.app.pokedex.app.ui.views.dresseur.viewModels

import androidx.lifecycle.ViewModel
import com.app.pokedex.app.common.api.AppService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DresseurViewModel @Inject constructor(
    private val appService: AppService
) : ViewModel() {

}