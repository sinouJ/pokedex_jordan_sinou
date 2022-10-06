package com.app.pokedex.app.ui.views.list.viewModels

import androidx.lifecycle.ViewModel
import com.app.pokedex.app.common.api.AppService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val appService: AppService
) : ViewModel() {

}