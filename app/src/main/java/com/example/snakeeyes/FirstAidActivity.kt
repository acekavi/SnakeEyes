package com.example.snakeeyes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.snakeeyes.R
import androidx.core.app.ActivityCompat
import android.app.Activity
import android.content.ComponentName
import android.content.Context
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import com.example.snakeeyes.MapsActivity
import kotlin.jvm.internal.Intrinsics
import android.widget.ImageButton
import com.example.snakeeyes.WebPageActivity
import com.example.snakeeyes.MenuActivity
import com.example.snakeeyes.CommonSnakesActivity

class FirstAidActivity : AppCompatActivity() {
    val phoneNumber = "1990"
    val rEQUEST_PHONE_CALL = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        val var10000 = this.supportActionBar
        var10000?.hide()
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_first_aid)
        if (ActivityCompat.checkSelfPermission(
                (this as Context),
                "android.permission.CALL_PHONE"
            ) != 0
        ) {
            ActivityCompat.requestPermissions(
                (this as Activity),
                arrayOf("android.permission.CALL_PHONE"),
                rEQUEST_PHONE_CALL
            )
        }
        val nav_home = findViewById<View>(R.id.navigation_home) as BottomNavigationItemView
        val nav_capture = findViewById<View>(R.id.navigation_capture) as BottomNavigationItemView
        val nav_snakes = findViewById<View>(R.id.navigation_snakes) as BottomNavigationItemView
        val mapButton = findViewById<View>(R.id.mapButton) as FloatingActionButton
        val map_button2 = findViewById<View>(R.id.map_button2) as Button
        map_button2.setOnClickListener(View.OnClickListener {
            this@FirstAidActivity.intent =
                Intent(this@FirstAidActivity as Context, MapsActivity::class.java)
            this@FirstAidActivity.startActivity(this@FirstAidActivity.intent)
        })
        mapButton.setOnClickListener(View.OnClickListener {
            this@FirstAidActivity.intent =
                Intent(this@FirstAidActivity as Context, MapsActivity::class.java)
            this@FirstAidActivity.startActivity(this@FirstAidActivity.intent)
        })
        Intrinsics.checkNotNullExpressionValue(nav_home, "nav_home")
        Intrinsics.checkNotNullExpressionValue(nav_capture, "nav_capture")
        Intrinsics.checkNotNullExpressionValue(nav_snakes, "nav_snakes")
        setNavBar(nav_home, nav_capture, nav_snakes)
        val mos = findViewById<View>(R.id.mapButton) as ImageButton
        mos.setOnClickListener(View.OnClickListener {
            this@FirstAidActivity.intent =
                Intent(this@FirstAidActivity as Context, WebPageActivity::class.java)
            this@FirstAidActivity.startActivity(this@FirstAidActivity.intent)
        })
        val call_button = findViewById<View>(R.id.call_button) as Button
        call_button.setOnClickListener(View.OnClickListener { startCall() })
    }

    private fun startCall() {
        val callIntent = Intent("android.intent.action.CALL")
        callIntent.data = Uri.parse("tel:" + phoneNumber)
        this.startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        Intrinsics.checkNotNullParameter(permissions, "permissions")
        Intrinsics.checkNotNullParameter(grantResults, "grantResults")
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == rEQUEST_PHONE_CALL) {
            startCall()
        }
    }

    private fun setNavBar(
        navHome: BottomNavigationItemView,
        nav_capture: BottomNavigationItemView,
        navSnakes: BottomNavigationItemView
    ) {
        navHome.setOnClickListener(View.OnClickListener {
            this@FirstAidActivity.intent =
                Intent(this@FirstAidActivity as Context, MenuActivity::class.java)
            this@FirstAidActivity.startActivity(this@FirstAidActivity.intent)
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
            this@FirstAidActivity.intent =
                Intent(this@FirstAidActivity as Context, CommonSnakesActivity::class.java)
            this@FirstAidActivity.startActivity(this@FirstAidActivity.intent)
        })
    }
}