package com.example.session1.retrofit.service

import com.example.session1.retrofit.model.LogIn
import com.example.session1.retrofit.model.Registration
import com.example.session1.retrofit.model.RespTok
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Interface {
    @POST("auth/login")
    suspend fun getLogin(@Body logIn: LogIn) : Response<RespTok>


    @POST ("auth/register")
    suspend fun getRegistrUser(@Body registration: Registration):Response<Registration>
}