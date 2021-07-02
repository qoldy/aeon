package com.example.aeon.mvvm.views

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.aeon.R
import com.example.aeon.utils.PrefHelper

class MainActivity:AppCompatActivity() {
    private lateinit var loginFragment:LoginFragment
    private lateinit var listFragment:ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        init()
    }

    private fun init(){
        PrefHelper.setContext(this)
        loginFragment = LoginFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, loginFragment)
                .commit()
    }

    fun onLoginClick(view: View){
        loginFragment.loginClick()
    }

    fun loggedIn(){
        loginFragment = LoginFragment()
        listFragment = ListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, listFragment)
            .commit()
    }

    fun onLogOutClick(view: View){
        loginFragment = LoginFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, loginFragment)
                .commit()
        PrefHelper.deleteToken()
    }
}