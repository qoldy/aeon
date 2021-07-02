package com.example.aeon.mvvm.models

import android.util.Log
import com.example.aeon.data.Payment
import com.example.aeon.mvvm.viewmodels.contracts.ListContract
import com.example.aeon.networking.RetrofitService
import com.example.aeon.utils.PrefHelper
import kotlinx.coroutines.*
import okhttp3.MediaType
import okhttp3.RequestBody
import kotlin.coroutines.coroutineContext

class ListModel(private val vm:ListContract) {
    private var job: Job?=null

    private val exceptionHandler = CoroutineExceptionHandler{ coroutineContext, throwable -> onError(throwable) }

    fun getList(){
        Log.v("model", "started")
        job= CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
            Log.v("token",PrefHelper.getToken().toString())
            val response= RetrofitService.getInstance()
                    .getList(RetrofitService.API_KEY, RetrofitService.VERSION, PrefHelper.getToken().toString())
            withContext(Dispatchers.Main) {
                if (response.body()!!.isSuccess)
                    onResponse(response.body()!!.list)
                else
                    onError()
            }
        }
    }

    private fun onError(throwable: Throwable){
        Log.e("error",throwable.message.toString())
    }
    private fun onError(){
        Log.e("error","response error")
    }

    private fun onResponse(list:ArrayList<Payment>){
        vm.onResponse(list)
    }
}