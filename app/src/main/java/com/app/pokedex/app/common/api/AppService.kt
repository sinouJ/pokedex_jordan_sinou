package com.app.pokedex.app.common.api

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppService @Inject constructor() {

    private var apiService : ApiService = ApiService.getInstance()
}