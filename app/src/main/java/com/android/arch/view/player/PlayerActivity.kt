package com.android.arch.view.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.arch.R

class PlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
    }
}
