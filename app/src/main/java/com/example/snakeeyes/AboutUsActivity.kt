package com.example.snakeeyes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_about_us)
    }
}