package com.example.snakeeyes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)

        var progressBar=findViewById<ProgressBar>(R.id.progressBar)
        setProgressBar(progressBar)


    }

    fun setProgressBar(progressBar: ProgressBar){
        val handler=Handler()
        progressBar.visibility=View.VISIBLE
        var i=progressBar.progress

        Thread(Runnable {
            while (i<100){
                i += 2
                handler.post(Runnable {
                    progressBar.progress=i
                })

                if( i==98){
                    intent= Intent(this,MenuActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                try {
                    Thread.sleep(100)
                }
                catch (e:InterruptedException){
                    e.printStackTrace()
                }
            }
        }).start()


    }




}