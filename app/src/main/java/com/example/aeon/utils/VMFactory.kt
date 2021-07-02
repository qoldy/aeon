package com.example.aeon.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aeon.mvvm.viewmodels.ListVM
import com.example.aeon.mvvm.viewmodels.LoginVM

class VMFactory: ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginVM::class.java))
            return LoginVM() as T
        if(modelClass.isAssignableFrom(ListVM::class.java))
            return ListVM() as T
        throw IllegalArgumentException ("UnknownViewModel")
    }
}