package com.example.aeon.mvvm.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.aeon.R
import com.example.aeon.mvvm.viewmodels.LoginVM
import com.example.aeon.utils.VMFactory

class LoginFragment:Fragment() {
    private lateinit var loginField:EditText
    private lateinit var passwordField:EditText

    private lateinit var loginVM: LoginVM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginField=view.findViewById(R.id.login_field)
        passwordField=view.findViewById(R.id.password_field)

        val factory = VMFactory()
        val provider = ViewModelProvider(this, factory)
        loginVM=provider.get(LoginVM::class.java)

        observeData()
    }

    private fun observeData(){
        loginVM.liveData.observe(viewLifecycleOwner,{
            if (loginVM.liveData.value == true){
                (activity as MainActivity).loggedIn()
            }
            else Toast.makeText(activity,"Log In Error",Toast.LENGTH_LONG).show()
        })
    }

    fun loginClick(){
        loginVM.loginToAccount(loginField.text.toString(),passwordField.text.toString())
    }
}