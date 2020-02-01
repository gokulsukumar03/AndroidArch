package com.android.arch.view.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.arch.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
