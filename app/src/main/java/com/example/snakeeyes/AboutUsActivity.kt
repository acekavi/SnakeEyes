package com.example.snakeeyes

import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.snakeeyes.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlin.jvm.internal.Intrinsics
import android.content.Intent
import android.view.View
import com.example.snakeeyes.MenuActivity
import com.example.snakeeyes.CommonSnakesActivity

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val var10000 = this.supportActionBar
        var10000?.hide()
        this.setContentView(R.layout.activity_about_us)
        val nav_home = findViewById<View>(R.id.navigation_home) as BottomNavigationItemView
        val nav_capture = findViewById<View>(R.id.navigation_capture) as BottomNavigationItemView
        val nav_snakes = findViewById<View>(R.id.navigation_snakes) as BottomNavigationItemView
        Intrinsics.checkNotNullExpressionValue(nav_home, "nav_home")
        Intrinsics.checkNotNullExpressionValue(nav_capture, "nav_capture")
        Intrinsics.checkNotNullExpressionValue(nav_snakes, "nav_snakes")
        setNavBar(nav_home, nav_capture, nav_snakes)
    }

    private fun setNavBar(
        navHome: BottomNavigationItemView,
        nav_capture: BottomNavigationItemView,
        navSnakes: BottomNavigationItemView
    ) {
        navHome.setOnClickListener(View.OnClickListener {
            this@AboutUsActivity.intent =
                Intent(this@AboutUsActivity as Context, MenuActivity::class.java)
            this@AboutUsActivity.startActivity(this@AboutUsActivity.intent)
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
            this@AboutUsActivity.intent =
                Intent(this@AboutUsActivity as Context, CommonSnakesActivity::class.java)
            this@AboutUsActivity.startActivity(this@AboutUsActivity.intent)
        })
    }
}