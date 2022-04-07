package com.example.snakeeyes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FirstAidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_aid)
        var nav_home=findViewById<BottomNavigationItemView>(R.id.navigation_home)
        var nav_capture=findViewById<BottomNavigationItemView>(R.id.navigation_capture)
        var nav_snakes=findViewById<BottomNavigationItemView>(R.id.navigation_snakes)

        var mapButton=findViewById<FloatingActionButton>(R.id.mapButton)

        mapButton.setOnClickListener {
            intent=Intent(this,MapsActivity::class.java)
            startActivity(intent)
        }

        setNavBar(nav_home,nav_capture,nav_snakes)
    }

    private fun setNavBar(navHome: BottomNavigationItemView, nav_capture: BottomNavigationItemView, navSnakes: BottomNavigationItemView) {
        navHome.setOnClickListener {
            intent= Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
        nav_capture.setOnClickListener {
            intent= Intent(this,CaptureActivity::class.java)
            startActivity(intent)
        }
        navSnakes.setOnClickListener {
            intent= Intent(this,CommonSnakesActivity::class.java)
            startActivity(intent)
        }
    }
}