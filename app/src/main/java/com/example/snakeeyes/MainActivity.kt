package com.example.snakeeyes

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.snakeeyes.R
import android.content.Intent
import com.example.snakeeyes.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)
        this.intent = Intent(this as Context, HomeActivity::class.java)
        this.startActivity(this.intent)
        finish()
    }
}