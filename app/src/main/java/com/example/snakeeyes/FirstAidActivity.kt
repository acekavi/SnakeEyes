package com.example.snakeeyes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FirstAidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_aid)
    }
}