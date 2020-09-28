package com.samone.project6.registerlogin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.samone.project6.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            val email = email_edittext_login.text.toString()
            val password = password_edittext_login.text.toString()

            Log.d("LoginActivity", "Attempt login with email and password")

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener

                    //else if successful
                    Log.d("Login","Successfully logged in")
                }
                .addOnFailureListener {
                    Log.d("Login","Failed to login: ${it.message}")
                }

        }

        back_to_register_textview.setOnClickListener {
            finish()
        }

    }

}