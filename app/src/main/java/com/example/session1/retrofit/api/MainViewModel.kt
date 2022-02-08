package com.example.session1.retrofit.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.session1.retrofit.model.LogIn
import com.example.session1.retrofit.model.Registration
import com.example.session1.retrofit.model.RespTok
import com.example.session1.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Body

class MainViewModel(private val repository: Repository):ViewModel() {
    val myResponse :MutableLiveData<Response<RespTok>> = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<Registration>> = MutableLiveData()
    fun getLogin(@Body logIn: LogIn){
        viewModelScope.launch {
            val response = repository.getLogin(logIn)
            myResponse.value = response
        }
    }
    fun getRegistrUser(@Body registration: Registration){
        viewModelScope.launch {
            val response = repository.getRegistrUser(registration)
            myResponse2.value = response
        }
    }


}