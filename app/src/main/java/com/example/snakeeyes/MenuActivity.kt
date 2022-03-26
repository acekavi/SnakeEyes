package com.example.snakeeyes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_menu)

        var commonsnakes=findViewById<Button>(R.id.commonSnakes)
        var capture=findViewById<Button>(R.id.capture)
        var firstaid=findViewById<Button>(R.id.firstAid)
        var about=findViewById<Button>(R.id.about)

        commonsnakes.setOnClickListener {
            intent= Intent(this,CommonSnakesActivity::class.java)
            startActivity(intent)
        }
        capture.setOnClickListener {
            intent= Intent(this,CaptureActivity::class.java)
            startActivity(intent)
        }
        firstaid.setOnClickListener {
            intent= Intent(this,FirstAidActivity::class.java)
            startActivity(intent)
        }
        about.setOnClickListener {
            intent= Intent(this,AboutUsActivity::class.java)
            startActivity(intent)
        }
    }
}