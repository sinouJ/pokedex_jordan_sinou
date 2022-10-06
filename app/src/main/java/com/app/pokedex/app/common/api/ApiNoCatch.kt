package com.app.pokedex.app.common.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> callApiNoCatch(block: suspend () -> T): T? =
    withContext(Dispatchers.IO) {
        try {
            block()
        } catch (ex: Exception) {
            println("callApiNoCatch = " + ex.localizedMessage)
            null
        }
    }