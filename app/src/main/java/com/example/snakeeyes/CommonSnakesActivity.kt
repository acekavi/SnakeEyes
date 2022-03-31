package com.example.snakeeyes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class CommonSnakesActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_snakes)

        var nav_home=findViewById<BottomNavigationItemView>(R.id.navigation_home)
        var nav_capture=findViewById<BottomNavigationItemView>(R.id.navigation_capture)
        var nav_snakes=findViewById<BottomNavigationItemView>(R.id.navigation_snakes)

        setNavBar(nav_home,nav_capture,nav_snakes)

        var cobraButton=findViewById<Button>(R.id.cobra_button)
        cobraButton.setOnClickListener {
            var family="Elapidae"
            var Scientific_Name="Naja Naja"
            var toxicity="HIGHLY-VENOMOUS"
            var Description="HIGHLY-VENOMOUS"
            intent= Intent(this,SnakeActivity::class.java).also {
                it.putExtra("FAMILY",family)
                it.putExtra("SCIENTIFIC_NAME",Scientific_Name)
                it.putExtra("TOXICITY",toxicity)
                it.putExtra("DESCRIPTION",Description)
                startActivity(it)
            }

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

    override fun onStart() {
        super.onStart()
        var cobraProgress =findViewById<ProgressBar>(R.id.cobra_progressbar)
        setprogressBar(cobraProgress,90)

        var commonkraitProgress =findViewById<ProgressBar>(R.id.commonkrait_progressbar)
        setprogressBar(commonkraitProgress,80)


        var humpNosedPitViperProgress =findViewById<ProgressBar>(R.id.humpNosedPitViper_progressbar)
        setprogressBar(humpNosedPitViperProgress,80)


        var greenTreeVineProgress =findViewById<ProgressBar>(R.id.greenTreeVine_progressbar)
        setprogressBar(greenTreeVineProgress,50)

        var commonSandBoaProgress =findViewById<ProgressBar>(R.id.commonSandBoa_progressbar)
        setprogressBar(commonSandBoaProgress,20)

        var indianRockPythonProgress =findViewById<ProgressBar>(R.id.indianRockPython_progressbar)
        setprogressBar(indianRockPythonProgress,20)

        var ratSnakeProgress =findViewById<ProgressBar>(R.id.ratSnake_progressbar)
        setprogressBar(ratSnakeProgress,20)

        var russellasViperProgress =findViewById<ProgressBar>(R.id.russellasViper_progressbar)
        setprogressBar(russellasViperProgress,70)

        var sawScaledVipeProgress =findViewById<ProgressBar>(R.id.sawScaledViper_progressbar)
        setprogressBar(sawScaledVipeProgress,70)
    }

    fun setprogressBar(progressBar: ProgressBar,limit:Int){
      //  var handler=Handler()
        progressBar.visibility=View.VISIBLE
        progressBar.progress=limit
      /**  Thread(Runnable {
            while (i<limit){
                i++
                handler.post(Runnable {
                    progressBar.progress=i
                })
                try {
                    Thread.sleep(50)
                }
                catch (e:InterruptedException){
                    e.printStackTrace()
                }

            }
        }).start() **/

    }
}