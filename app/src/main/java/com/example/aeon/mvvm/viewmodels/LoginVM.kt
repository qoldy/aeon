package com.example.aeon.mvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aeon.mvvm.models.LoginModel
import com.example.aeon.mvvm.viewmodels.contracts.LoginContract
import okhttp3.MediaType
import okhttp3.RequestBody

class LoginVM:ViewModel(), LoginContract {
    val liveData=MutableLiveData<Boolean>()
    private var model = LoginModel(this)
    fun loginToAccount(login:String, password:String){
        model.login(
            RequestBody.create(MediaType.parse("text/plain"),login),
            RequestBody.create(MediaType.parse("text/plain"),password)
        )
    }

    override fun onError() {
        liveData.value=false
    }

    override fun onResponse() {
        liveData.value=true
    }
}