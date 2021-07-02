package com.example.aeon.utils

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log

class PrefHelper {
    companion object{
        private const val PREF="pref"
        private const val PREF_TOKEN="token"
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context
        fun setContext(c:Context){
            context=c
        }
        fun saveToken(token:String){
            val sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            sharedPreferences.edit()
                    .putString(PREF_TOKEN, token)
                    .apply()
        }

        fun getToken(): String? {
            val sharedPreferences = context.getSharedPreferences(PREF,Context.MODE_PRIVATE)
            return sharedPreferences.getString(PREF_TOKEN,"token")
        }

        fun deleteToken(){
            val sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            sharedPreferences.edit()
                    .putString(PREF_TOKEN, "")
                    .apply()
        }
    }
}