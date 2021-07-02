package com.example.aeon.mvvm.models

import android.util.Log
import com.example.aeon.mvvm.viewmodels.contracts.LoginContract
import com.example.aeon.networking.RetrofitService
import com.example.aeon.utils.PrefHelper
import kotlinx.coroutines.*
import okhttp3.RequestBody

class LoginModel(private val vm: LoginContract) {
    private var job:Job?=null

    private val exceptionHandler = CoroutineExceptionHandler{ coroutineContext, throwable -> onError(throwable) }

    fun login(login:RequestBody, password:RequestBody){
        job=CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            val response=RetrofitService.getInstance()
                    .login(RetrofitService.API_KEY, RetrofitService.VERSION, login, password)
            withContext(Dispatchers.Main) {
                if (response.body()!!.isSuccess) {
                    onResponse(response.body()!!.inside.token)
                }
                else
                    onError()
            }
        }
    }

    private fun onError(throwable: Throwable){
        Log.e("error",throwable.message.toString())
        vm.onError()
    }

    private fun onError(){
        vm.onError()
    }

    private fun onResponse(token:String){
        PrefHelper.saveToken(token)
        vm.onResponse()
    }
}