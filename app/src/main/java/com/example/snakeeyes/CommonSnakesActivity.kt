package com.example.snakeeyes

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import com.example.snakeeyes.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlin.jvm.internal.Intrinsics
import com.example.snakeeyes.CommonSnakesActivity
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.snakeeyes.SnakeActivity
import com.example.snakeeyes.MenuActivity
import android.widget.ProgressBar
import okhttp3.*
import org.json.JSONObject
import org.json.JSONException
import java.io.IOException

class CommonSnakesActivity : AppCompatActivity() {
    private var name: String? = ""
    private var scientificName: String? = ""
    private var type: String? = ""
    private var size: String? = ""
    private var color: String? = ""
    private var weight: String? = ""
    private var family: String? = ""
    private var genus: String? = ""
    private var venomType: String? = ""
    private var desc: String? = ""
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        val var10000 = this.supportActionBar
        var10000?.hide()
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_common_snakes)
        val nav_home = findViewById<View>(R.id.navigation_home) as BottomNavigationItemView
        val nav_capture = findViewById<View>(R.id.navigation_capture) as BottomNavigationItemView
        val nav_snakes = findViewById<View>(R.id.navigation_snakes) as BottomNavigationItemView
        Intrinsics.checkNotNullExpressionValue(nav_home, "nav_home")
        Intrinsics.checkNotNullExpressionValue(nav_capture, "nav_capture")
        Intrinsics.checkNotNullExpressionValue(nav_snakes, "nav_snakes")
        setNavBar(nav_home, nav_capture, nav_snakes)
        val cobraButton = findViewById<View>(R.id.cobra_button) as Button
        val commonKraitButton = findViewById<View>(R.id.commonkrait_button) as Button
        val humpNosedPitViperButton = findViewById<View>(R.id.humpNosedPitViper_button) as Button
        val ratSnakeButton = findViewById<View>(R.id.ratSnake_button) as Button
        val russellasViperButton = findViewById<View>(R.id.russellasViper_button) as Button
        val sawScaledViperButton = findViewById<View>(R.id.sawScaledViper_button) as Button
        val greenTreeVineButton = findViewById<View>(R.id.greenTreeVine_button) as Button
        val indianRockPythonButton = findViewById<View>(R.id.indianRockPython_button) as Button
        val commonSandBoaButton = findViewById<View>(R.id.commonSandBoa_button) as Button
        cobraButton.setOnClickListener(View.OnClickListener {
            val snakeId = "{\"snakeid\":\"62401ff856d67da73d2bbbbe\"}"
            sendRequest(snakeId)
            val var10000 = this@CommonSnakesActivity
            val var3 = Intent(this@CommonSnakesActivity as Context, SnakeActivity::class.java)
            val var6 = var10000
            val var5 = false
            var3.putExtra("FAMILY", family)
            var3.putExtra("SCIENTIFIC_NAME", scientificName)
            var3.putExtra("TOXICITY", type)
            var3.putExtra("DESCRIPTION", desc)
            var3.putExtra("NAME", name)
            var3.putExtra("SIZE", size)
            var3.putExtra("WEIGHT", weight)
            var3.putExtra("GENUS", genus)
            var3.putExtra("COLOR", color)
            var3.putExtra("VENOM_TYPE", venomType)
            var3.putExtra("SNAKEID", "62401ff856d67da73d2bbbbe")
            this@CommonSnakesActivity.startActivity(var3)
            val var7 = Unit
            var6.intent = var3
        })
        commonKraitButton.setOnClickListener(View.OnClickListener {
            val snakeId: Any = "{\"snakeid\":\"62403239bc4ea173bbc6296b\"}"
            val var10000 = this@CommonSnakesActivity
            val var3 = Intent(this@CommonSnakesActivity as Context, SnakeActivity::class.java)
            val var6 = var10000
            val var5 = false
            sendRequest(snakeId as String)
            var3.putExtra("FAMILY", family)
            var3.putExtra("SCIENTIFIC_NAME", scientificName)
            var3.putExtra("TOXICITY", type)
            var3.putExtra("DESCRIPTION", desc)
            var3.putExtra("NAME", name)
            var3.putExtra("SIZE", size)
            var3.putExtra("WEIGHT", weight)
            var3.putExtra("GENUS", genus)
            var3.putExtra("COLOR", color)
            var3.putExtra("VENOM_TYPE", venomType)
            var3.putExtra("SNAKEID", "62403239bc4ea173bbc6296b")
            this@CommonSnakesActivity.startActivity(var3)
            val var7 = Unit
            var6.intent = var3
        })
        humpNosedPitViperButton.setOnClickListener(View.OnClickListener {
            val snakeId: Any = "{\"snakeid\":\"62403383c92dc4ffbd9386d6\"}"
            val var10000 = this@CommonSnakesActivity
            val var3 = Intent(this@CommonSnakesActivity as Context, SnakeActivity::class.java)
            val var6 = var10000
            val var5 = false
            sendRequest(snakeId as String)
            var3.putExtra("FAMILY", family)
            var3.putExtra("SCIENTIFIC_NAME", scientificName)
            var3.putExtra("TOXICITY", type)
            var3.putExtra("DESCRIPTION", desc)
            var3.putExtra("NAME", name)
            var3.putExtra("SIZE", size)
            var3.putExtra("WEIGHT", weight)
            var3.putExtra("GENUS", genus)
            var3.putExtra("COLOR", color)
            var3.putExtra("VENOM_TYPE", venomType)
            var3.putExtra("SNAKEID", "62403383c92dc4ffbd9386d6")
            this@CommonSnakesActivity.startActivity(var3)
            val var7 = Unit
            var6.intent = var3
        })
        ratSnakeButton.setOnClickListener(View.OnClickListener {
            val snakeId: Any = "{\"snakeid\":\"62403414c92dc4ffbd9386d8\"}"
            val var10000 = this@CommonSnakesActivity
            val var3 = Intent(this@CommonSnakesActivity as Context, SnakeActivity::class.java)
            val var6 = var10000
            val var5 = false
            sendRequest(snakeId as String)
            var3.putExtra("FAMILY", family)
            var3.putExtra("SCIENTIFIC_NAME", scientificName)
            var3.putExtra("TOXICITY", type)
            var3.putExtra("DESCRIPTION", desc)
            var3.putExtra("NAME", name)
            var3.putExtra("SIZE", size)
            var3.putExtra("WEIGHT", weight)
            var3.putExtra("GENUS", genus)
            var3.putExtra("COLOR", color)
            var3.putExtra("VENOM_TYPE", venomType)
            var3.putExtra("SNAKEID", "62403414c92dc4ffbd9386d8")
            this@CommonSnakesActivity.startActivity(var3)
            val var7 = Unit
            var6.intent = var3
        })
        russellasViperButton.setOnClickListener(View.OnClickListener {
            val snakeId: Any = "{\"snakeid\":\"6240348dc92dc4ffbd9386da\"}"
            val var10000 = this@CommonSnakesActivity
            val var3 = Intent(this@CommonSnakesActivity as Context, SnakeActivity::class.java)
            val var6 = var10000
            val var5 = false
            sendRequest(snakeId as String)
            var3.putExtra("FAMILY", family)
            var3.putExtra("SCIENTIFIC_NAME", scientificName)
            var3.putExtra("TOXICITY", type)
            var3.putExtra("DESCRIPTION", desc)
            var3.putExtra("NAME", name)
            var3.putExtra("SIZE", size)
            var3.putExtra("WEIGHT", weight)
            var3.putExtra("GENUS", genus)
            var3.putExtra("COLOR", color)
            var3.putExtra("VENOM_TYPE", venomType)
            var3.putExtra("SNAKEID", "6240348dc92dc4ffbd9386da")
            this@CommonSnakesActivity.startActivity(var3)
            val var7 = Unit
            var6.intent = var3
        })
        sawScaledViperButton.setOnClickListener(View.OnClickListener {
            val snakeId: Any = "{\"snakeid\":\"62403516c92dc4ffbd9386dc\"}"
            val var10000 = this@CommonSnakesActivity
            val var3 = Intent(this@CommonSnakesActivity as Context, SnakeActivity::class.java)
            val var6 = var10000
            val var5 = false
            sendRequest(snakeId as String)
            var3.putExtra("FAMILY", family)
            var3.putExtra("SCIENTIFIC_NAME", scientificName)
            var3.putExtra("TOXICITY", type)
            var3.putExtra("DESCRIPTION", desc)
            var3.putExtra("NAME", name)
            var3.putExtra("SIZE", size)
            var3.putExtra("WEIGHT", weight)
            var3.putExtra("GENUS", genus)
            var3.putExtra("COLOR", color)
            var3.putExtra("VENOM_TYPE", venomType)
            var3.putExtra("SNAKEID", "62403516c92dc4ffbd9386dc")
            this@CommonSnakesActivity.startActivity(var3)
            val var7 = Unit
            var6.intent = var3
        })
        greenTreeVineButton.setOnClickListener(View.OnClickListener {
            val snakeId: Any = "{\"snakeid\":\"6240359bc92dc4ffbd9386de\"}"
            val var10000 = this@CommonSnakesActivity
            val var3 = Intent(this@CommonSnakesActivity as Context, SnakeActivity::class.java)
            val var6 = var10000
            val var5 = false
            sendRequest(snakeId as String)
            var3.putExtra("FAMILY", family)
            var3.putExtra("SCIENTIFIC_NAME", scientificName)
            var3.putExtra("TOXICITY", type)
            var3.putExtra("DESCRIPTION", desc)
            var3.putExtra("NAME", name)
            var3.putExtra("SIZE", size)
            var3.putExtra("WEIGHT", weight)
            var3.putExtra("GENUS", genus)
            var3.putExtra("COLOR", color)
            var3.putExtra("VENOM_TYPE", venomType)
            var3.putExtra("SNAKEID", "6240359bc92dc4ffbd9386de")
            this@CommonSnakesActivity.startActivity(var3)
            val var7 = Unit
            var6.intent = var3
        })
        indianRockPythonButton.setOnClickListener(View.OnClickListener {
            val snakeId: Any = "{\"snakeid\":\"62403620c92dc4ffbd9386e0\"}"
            val var10000 = this@CommonSnakesActivity
            val var3 = Intent(this@CommonSnakesActivity as Context, SnakeActivity::class.java)
            val var6 = var10000
            val var5 = false
            sendRequest(snakeId as String)
            var3.putExtra("FAMILY", family)
            var3.putExtra("SCIENTIFIC_NAME", scientificName)
            var3.putExtra("TOXICITY", type)
            var3.putExtra("DESCRIPTION", desc)
            var3.putExtra("NAME", name)
            var3.putExtra("SIZE", size)
            var3.putExtra("WEIGHT", weight)
            var3.putExtra("GENUS", genus)
            var3.putExtra("COLOR", color)
            var3.putExtra("VENOM_TYPE", venomType)
            var3.putExtra("SNAKEID", "62403620c92dc4ffbd9386e0")
            this@CommonSnakesActivity.startActivity(var3)
            val var7 = Unit
            var6.intent = var3
        })
        commonSandBoaButton.setOnClickListener(View.OnClickListener {
            val snakeId: Any = "{\"snakeid\":\"624036a8c92dc4ffbd9386e2\"}"
            val var10000 = this@CommonSnakesActivity
            val var3 = Intent(this@CommonSnakesActivity as Context, SnakeActivity::class.java)
            val var6 = var10000
            val var5 = false
            sendRequest(snakeId as String)
            var3.putExtra("FAMILY", family)
            var3.putExtra("SCIENTIFIC_NAME", scientificName)
            var3.putExtra("TOXICITY", type)
            var3.putExtra("DESCRIPTION", desc)
            var3.putExtra("NAME", name)
            var3.putExtra("SIZE", size)
            var3.putExtra("WEIGHT", weight)
            var3.putExtra("GENUS", genus)
            var3.putExtra("COLOR", color)
            var3.putExtra("VENOM_TYPE", venomType)
            var3.putExtra("SNAKEID", "624036a8c92dc4ffbd9386e2")
            this@CommonSnakesActivity.startActivity(var3)
            val var7 = Unit
            var6.intent = var3
        })
    }

    private fun setNavBar(
        navHome: BottomNavigationItemView,
        nav_capture: BottomNavigationItemView,
        navSnakes: BottomNavigationItemView
    ) {
        navHome.setOnClickListener(View.OnClickListener {
            this@CommonSnakesActivity.intent =
                Intent(this@CommonSnakesActivity as Context, MenuActivity::class.java)
            this@CommonSnakesActivity.startActivity(this@CommonSnakesActivity.intent)
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
            this@CommonSnakesActivity.intent =
                Intent(this@CommonSnakesActivity as Context, CommonSnakesActivity::class.java)
            this@CommonSnakesActivity.startActivity(this@CommonSnakesActivity.intent)
        })
    }

    override fun onStart() {
        super.onStart()
        val cobraProgress = findViewById<View>(R.id.cobra_progressbar) as ProgressBar
        Intrinsics.checkNotNullExpressionValue(cobraProgress, "cobraProgress")
        setprogressBar(cobraProgress, 90)
        val commonkraitProgress = findViewById<View>(R.id.commonkrait_progressbar) as ProgressBar
        Intrinsics.checkNotNullExpressionValue(commonkraitProgress, "commonkraitProgress")
        setprogressBar(commonkraitProgress, 80)
        val humpNosedPitViperProgress =
            findViewById<View>(R.id.humpNosedPitViper_progressbar) as ProgressBar
        Intrinsics.checkNotNullExpressionValue(
            humpNosedPitViperProgress,
            "humpNosedPitViperProgress"
        )
        setprogressBar(humpNosedPitViperProgress, 80)
        val greenTreeVineProgress =
            findViewById<View>(R.id.greenTreeVine_progressbar) as ProgressBar
        Intrinsics.checkNotNullExpressionValue(greenTreeVineProgress, "greenTreeVineProgress")
        setprogressBar(greenTreeVineProgress, 50)
        val commonSandBoaProgress =
            findViewById<View>(R.id.commonSandBoa_progressbar) as ProgressBar
        Intrinsics.checkNotNullExpressionValue(commonSandBoaProgress, "commonSandBoaProgress")
        setprogressBar(commonSandBoaProgress, 20)
        val indianRockPythonProgress =
            findViewById<View>(R.id.indianRockPython_progressbar) as ProgressBar
        Intrinsics.checkNotNullExpressionValue(indianRockPythonProgress, "indianRockPythonProgress")
        setprogressBar(indianRockPythonProgress, 20)
        val ratSnakeProgress = findViewById<View>(R.id.ratSnake_progressbar) as ProgressBar
        Intrinsics.checkNotNullExpressionValue(ratSnakeProgress, "ratSnakeProgress")
        setprogressBar(ratSnakeProgress, 20)
        val russellasViperProgress =
            findViewById<View>(R.id.russellasViper_progressbar) as ProgressBar
        Intrinsics.checkNotNullExpressionValue(russellasViperProgress, "russellasViperProgress")
        setprogressBar(russellasViperProgress, 70)
        val sawScaledVipeProgress =
            findViewById<View>(R.id.sawScaledViper_progressbar) as ProgressBar
        Intrinsics.checkNotNullExpressionValue(sawScaledVipeProgress, "sawScaledVipeProgress")
        setprogressBar(sawScaledVipeProgress, 70)
    }

    fun setprogressBar(progressBar: ProgressBar, limit: Int) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar")
        progressBar.visibility = View.VISIBLE
        progressBar.progress = limit
    }

    private fun sendRequest(snakeIdString: String) {
        val client = OkHttpClient()
        val rq =
            RequestBody.create(MediaType.parse("application/json; charset=utf-8"), snakeIdString)
        val request = Request.Builder()
            .url("http://172.20.10.3:8000/api/view_snakes").method("POST", rq)
            .header("Content-Type", "application/json").build()
        client.newCall(request).enqueue(object : Callback {
            @SuppressLint("LongLogTag")
            override fun onFailure(call: Call, e: IOException) {
                Intrinsics.checkNotNullParameter(call, "call")
                Intrinsics.checkNotNullParameter(e, "e")
                Log.d("IOException: ", e.message.toString())
                Log.d(
                    "If failed to connect to the given ip address in the request url ",
                    "find your current ip address and add it to the network_security.xml file and the request url."
                )
            }

            override fun onResponse(call: Call, res: Response) {
                Intrinsics.checkNotNullParameter(call, "call")
                Intrinsics.checkNotNullParameter(res, "res")
                Log.d(
                    "Check response:",
                    "-------------------- response received --------------------"
                )
                val var10000 = res.body()
                var snake: String? = null
                try {
                    snake = var10000?.string()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                if (snake != null) {
                    Log.d("Snake", snake)
                    var snakeObj: JSONObject? = null
                    try {
                        snakeObj = JSONObject(snake)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    setGlobalVar(snakeObj)
                }
            }
        } as Callback)
    }

    private fun setGlobalVar(snake: JSONObject?) {
        var var10001: String? = null
        try {
            var10001 = snake!!.getString("snakeName")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Intrinsics.checkNotNullExpressionValue(var10001, "snake.getString(\"snakeName\")")
        name = var10001
        try {
            var10001 = snake!!.getString("snakeScientificName")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Intrinsics.checkNotNullExpressionValue(var10001, "snake.getString(\"snakeScientificName\")")
        scientificName = var10001
        try {
            var10001 = snake!!.getString("snakeType")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Intrinsics.checkNotNullExpressionValue(var10001, "snake.getString(\"snakeType\")")
        type = var10001
        try {
            var10001 = snake!!.getString("snakeAvgSize")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Intrinsics.checkNotNullExpressionValue(var10001, "snake.getString(\"snakeAvgSize\")")
        size = var10001
        try {
            var10001 = snake!!.getString("snakeColor")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Intrinsics.checkNotNullExpressionValue(var10001, "snake.getString(\"snakeColor\")")
        color = var10001
        try {
            var10001 = snake!!.getString("Weight")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Intrinsics.checkNotNullExpressionValue(var10001, "snake.getString(\"Weight\")")
        weight = var10001
        try {
            var10001 = snake!!.getString("Family")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Intrinsics.checkNotNullExpressionValue(var10001, "snake.getString(\"Family\")")
        family = var10001
        try {
            var10001 = snake!!.getString("Genus")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Intrinsics.checkNotNullExpressionValue(var10001, "snake.getString(\"Genus\")")
        genus = var10001
        try {
            var10001 = snake!!.getString("snakeVenomType")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Intrinsics.checkNotNullExpressionValue(var10001, "snake.getString(\"snakeVenomType\")")
        venomType = var10001
        try {
            var10001 = snake!!.getString("snakeDescription")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        Intrinsics.checkNotNullExpressionValue(var10001, "snake.getString(\"snakeDescription\")")
        desc = var10001
        Log.i("name2", name!!)
    }

    companion object {
        // $FF: synthetic method
        fun `access$setFamily$p`(`$this`: CommonSnakesActivity, var1: String?) {
            `$this`.family = var1
        }

        // $FF: synthetic method
        fun `access$setScientificName$p`(`$this`: CommonSnakesActivity, var1: String?) {
            `$this`.scientificName = var1
        }

        // $FF: synthetic method
        fun `access$setType$p`(`$this`: CommonSnakesActivity, var1: String?) {
            `$this`.type = var1
        }

        // $FF: synthetic method
        fun `access$setDesc$p`(`$this`: CommonSnakesActivity, var1: String?) {
            `$this`.desc = var1
        }

        // $FF: synthetic method
        fun `access$setName$p`(`$this`: CommonSnakesActivity, var1: String?) {
            `$this`.name = var1
        }

        // $FF: synthetic method
        fun `access$setSize$p`(`$this`: CommonSnakesActivity, var1: String?) {
            `$this`.size = var1
        }

        // $FF: synthetic method
        fun `access$setWeight$p`(`$this`: CommonSnakesActivity, var1: String?) {
            `$this`.weight = var1
        }

        // $FF: synthetic method
        fun `access$setGenus$p`(`$this`: CommonSnakesActivity, var1: String?) {
            `$this`.genus = var1
        }

        // $FF: synthetic method
        fun `access$setColor$p`(`$this`: CommonSnakesActivity, var1: String?) {
            `$this`.color = var1
        }

        // $FF: synthetic method
        fun `access$setVenomType$p`(`$this`: CommonSnakesActivity, var1: String?) {
            `$this`.venomType = var1
        }
    }
}