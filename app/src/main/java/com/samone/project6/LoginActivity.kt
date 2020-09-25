package com.samone.project6

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            val email = email_edittext_login.text.toString()
            val password = password_edittext_login.text.toString()

            Log.d("LoginActivity", "Email is: $email")
            Log.d("LoginActivity", "password is: $password")
            Log.d("LoginActivity", "Login Button clicked")
        }

        back_to_register_textview.setOnClickListener {
            finish()
        }

    }

}