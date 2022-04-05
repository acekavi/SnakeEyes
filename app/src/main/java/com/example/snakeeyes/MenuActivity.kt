package com.example.snakeeyes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_menu)

        var nav_home=findViewById<BottomNavigationItemView>(R.id.navigation_home)
        var nav_capture=findViewById<BottomNavigationItemView>(R.id.navigation_capture)
        var nav_snakes=findViewById<BottomNavigationItemView>(R.id.navigation_snakes)

        var commonsnakes=findViewById<Button>(R.id.commonSnakes)
        var capture=findViewById<Button>(R.id.capture)
        var firstaid=findViewById<Button>(R.id.firstAid)
        var about=findViewById<Button>(R.id.about)

        commonsnakes.setOnClickListener {
            intent= Intent(this,CommonSnakesActivity::class.java)
            startActivity(intent)
        }
        capture.setOnClickListener {
            intent= Intent(this,MapsActivity::class.java)
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
    private fun setNavBar(navHome: BottomNavigationItemView, nav_capture: BottomNavigationItemView, navSnakes: BottomNavigationItemView) {
        navHome.setOnClickListener {
            intent=Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
        nav_capture.setOnClickListener {
            intent=Intent(this,CaptureActivity::class.java)
            startActivity(intent)
        }
        navSnakes.setOnClickListener {
            intent=Intent(this,CommonSnakesActivity::class.java)
            startActivity(intent)
        }
    }
}