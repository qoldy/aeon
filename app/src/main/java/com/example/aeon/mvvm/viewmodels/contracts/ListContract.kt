package com.example.aeon.mvvm.viewmodels.contracts

import com.example.aeon.data.Payment

interface ListContract {
    fun onResponse(paymentList:ArrayList<Payment>)
}