package com.example.session1.retrofit.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Instance {
    private val BASE = "http://cinema.areas.su/"
    private val retrofit = Retrofit.Builder().baseUrl(BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiServ = retrofit.create(Interface::class.java)
}