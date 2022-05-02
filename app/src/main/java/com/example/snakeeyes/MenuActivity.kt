package com.example.snakeeyes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.snakeeyes.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlin.jvm.internal.Intrinsics
import android.content.Intent
import com.example.snakeeyes.CommonSnakesActivity
import android.content.ComponentName
import android.content.Context
import android.view.View
import android.widget.Button
import com.example.snakeeyes.FirstAidActivity
import com.example.snakeeyes.AboutUsActivity
import com.example.snakeeyes.MenuActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val var10000 = this.supportActionBar
        var10000?.hide()
        this.setContentView(R.layout.activity_menu)
        val nav_home = findViewById<View>(R.id.navigation_home) as BottomNavigationItemView
        val nav_capture = findViewById<View>(R.id.navigation_capture) as BottomNavigationItemView
        val nav_snakes = findViewById<View>(R.id.navigation_snakes) as BottomNavigationItemView
        Intrinsics.checkNotNullExpressionValue(nav_home, "nav_home")
        Intrinsics.checkNotNullExpressionValue(nav_capture, "nav_capture")
        Intrinsics.checkNotNullExpressionValue(nav_snakes, "nav_snakes")
        setNavBar(nav_home, nav_capture, nav_snakes)
        val commonsnakes = findViewById<View>(R.id.commonSnakes) as Button
        val capture = findViewById<View>(R.id.capture) as Button
        val firstaid = findViewById<View>(R.id.firstAid) as Button
        val about = findViewById<View>(R.id.about) as Button
        commonsnakes.setOnClickListener(View.OnClickListener {
            this@MenuActivity.intent =
                Intent(this@MenuActivity as Context, CommonSnakesActivity::class.java)
            this@MenuActivity.startActivity(this@MenuActivity.intent)
        })
        capture.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.component = ComponentName(
                "org.tensorflow.lite.examples.detection",
                "org.tensorflow.lite.examples.detection.MainActivity"
            )
            startActivity(intent)
        })
        firstaid.setOnClickListener(View.OnClickListener {
            this@MenuActivity.intent =
                Intent(this@MenuActivity as Context, FirstAidActivity::class.java)
            this@MenuActivity.startActivity(this@MenuActivity.intent)
        })
        about.setOnClickListener(View.OnClickListener {
            this@MenuActivity.intent =
                Intent(this@MenuActivity as Context, AboutUsActivity::class.java)
            this@MenuActivity.startActivity(this@MenuActivity.intent)
        })
    }

    private fun setNavBar(
        navHome: BottomNavigationItemView,
        nav_capture: BottomNavigationItemView,
        navSnakes: BottomNavigationItemView
    ) {
        navHome.setOnClickListener(View.OnClickListener {
            this@MenuActivity.intent =
                Intent(this@MenuActivity as Context, MenuActivity::class.java)
            this@MenuActivity.startActivity(this@MenuActivity.intent)
        })
        nav_capture.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.component = ComponentName(
                "org.tensorflow.lite.examples.detection",
                "org.tensorflow.lite.examples.detection.MainActivity"
            )
            startActivity(intent)
        })
        navSnakes.setOnClickListener(View.OnClickListener {
            this@MenuActivity.intent =
                Intent(this@MenuActivity as Context, CommonSnakesActivity::class.java)
            this@MenuActivity.startActivity(this@MenuActivity.intent)
        })
    }
}