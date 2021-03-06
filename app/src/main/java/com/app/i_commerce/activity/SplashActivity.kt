package com.app.i_commerce.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.app.i_commerce.MainActivity
import com.app.i_commerce.R
import com.app.i_commerce.helper.SharedPref

class SplashActivity : AppCompatActivity() {
    lateinit var s: SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        s = SharedPref(this)
        Handler().postDelayed({

            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
        },3000)
    }
}