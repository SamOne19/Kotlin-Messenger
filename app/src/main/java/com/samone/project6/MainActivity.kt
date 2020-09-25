package com.samone.project6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPagerAdapter = ViewPageAdapter(supportFragmentManager)
        viewPagerAdapter.apply {
            add(GetStartedFragment1())
            add(GetStartedFragment2())
            add(GetStartedFragment1())
        }
        viewPager.adapter = viewPagerAdapter

        button.setOnClickListener {
            Toast.makeText(this,"We will get onto that",Toast.LENGTH_SHORT).show()
        }

    }
}