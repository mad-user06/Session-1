package com.example.session1.retrofit.repository

import com.example.session1.retrofit.model.LogIn
import com.example.session1.retrofit.model.Registration
import com.example.session1.retrofit.model.RespTok
import com.example.session1.retrofit.service.Instance
import retrofit2.Response
import retrofit2.http.Body

class Repository {
    suspend fun getLogin(@Body logIn: LogIn):Response<RespTok>{
        return Instance.apiServ.getLogin(logIn)
    }

    suspend fun getRegistrUser(@Body registration: Registration):Response<Registration>{
        return Instance.apiServ.getRegistrUser(registration)
    }
}