package com.example.aeon.mvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aeon.data.Payment
import com.example.aeon.mvvm.models.ListModel
import com.example.aeon.mvvm.viewmodels.contracts.ListContract

class ListVM:ViewModel(),ListContract {
    private var model = ListModel(this)
    val liveData = MutableLiveData<ArrayList<Payment>>()
    fun getList(){model.getList()}
    override fun onResponse(paymentList: ArrayList<Payment>) {
        liveData.value=paymentList
    }
}