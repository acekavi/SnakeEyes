package com.example.snakeeyes

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.snakeeyes.R
import android.widget.ProgressBar
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Ref.IntRef
import android.content.Intent
import android.os.Handler
import android.view.View
import com.example.snakeeyes.MenuActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val var10000 = this.supportActionBar
        var10000?.hide()
        this.setContentView(R.layout.activity_home)
        val progressBar = findViewById<View>(R.id.progressBar) as ProgressBar
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar")
        setProgressBar(progressBar)
    }

    fun setProgressBar(progressBar: ProgressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar")
        val handler = Handler()
        progressBar.visibility = View.VISIBLE
        val i = IntRef()
        i.element = progressBar.progress
        Thread(Runnable {
            while (i.element < 100) {
                ++i.element
                handler.post(Runnable { progressBar.progress = i.element })
                if (i.element == 99) {
                    this@HomeActivity.intent =
                        Intent(this@HomeActivity as Context, MenuActivity::class.java)
                    this@HomeActivity.startActivity(this@HomeActivity.intent)
                    finish()
                }
                try {
                    Thread.sleep(100L)
                } catch (var2: InterruptedException) {
                    var2.printStackTrace()
                }
            }
        }).start()
    }
}