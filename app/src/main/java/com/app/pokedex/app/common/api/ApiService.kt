package com.app.pokedex.app.common.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    companion object {
        private var apiService: ApiService? = null
        fun getInstance(): ApiService {
            println("ma grosse teub")
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://rickandmortyapi.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            println("mon énorme teub")
            return apiService!!
            println(apiService)
        }
    }

}