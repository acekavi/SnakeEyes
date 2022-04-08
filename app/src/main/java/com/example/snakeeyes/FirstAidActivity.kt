package com.example.snakeeyes

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.jar.Manifest

class FirstAidActivity : AppCompatActivity() {
    val phoneNumber="1990"
    val REQUEST_PHONE_CALL =1
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_aid)
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),REQUEST_PHONE_CALL)

        }
        var nav_home=findViewById<BottomNavigationItemView>(R.id.navigation_home)
        var nav_capture=findViewById<BottomNavigationItemView>(R.id.navigation_capture)
        var nav_snakes=findViewById<BottomNavigationItemView>(R.id.navigation_snakes)

        var mapButton=findViewById<FloatingActionButton>(R.id.mapButton)
        val map_button2=findViewById<Button>(R.id.map_button2)


        map_button2.setOnClickListener {
            intent=Intent(this,MapsActivity::class.java)
            startActivity(intent)
        }

        mapButton.setOnClickListener {
            intent=Intent(this,MapsActivity::class.java)
            startActivity(intent)
        }

        setNavBar(nav_home,nav_capture,nav_snakes)

        var mos=findViewById<ImageButton>(R.id.mosButton)
        mos.setOnClickListener {
            intent= Intent(this,WebPageActivity::class.java)
            startActivity(intent)
        }

        val call_button=findViewById<Button>(R.id.call_button)




        call_button.setOnClickListener {

            startCall()
        }


    }

    private fun startCall() {
        val callIntent=Intent(Intent.ACTION_CALL)
        callIntent.data = Uri.parse("tel:"+phoneNumber)
        startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray

    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //  super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==REQUEST_PHONE_CALL)startCall()
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