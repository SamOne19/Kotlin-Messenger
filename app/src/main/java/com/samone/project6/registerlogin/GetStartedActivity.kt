package com.samone.project6.registerlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.samone.project6.R
import kotlinx.android.synthetic.main.activity_get_started.*

class GetStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        get_started_button.setOnClickListener {
            Log.d("GetStartedActivity", "Going back to Register page")
            //this will lead back to register activity
            finish()
        }

    }
}