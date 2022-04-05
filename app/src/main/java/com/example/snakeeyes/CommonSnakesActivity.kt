package com.example.snakeeyes

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CommonSnakesActivity : AppCompatActivity() {
    // global variables
    private var name = "";
    private var scientificName = "";
    private var type = "";
    private var size = "";
    private var color = "";
    private var weight = "";
    private var family = "";
    private var genus = "";
    private var venomType = "";
    private var desc = "";


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_snakes)

        var nav_home=findViewById<BottomNavigationItemView>(R.id.navigation_home)
        var nav_capture=findViewById<BottomNavigationItemView>(R.id.navigation_capture)
        var nav_snakes=findViewById<BottomNavigationItemView>(R.id.navigation_snakes)

        setNavBar(nav_home,nav_capture,nav_snakes)

        //creating instances of see more buttons for snakes
        var cobraButton=findViewById<Button>(R.id.cobra_button)
        var commonKraitButton = findViewById<Button>(R.id.commonkrait_button);
        var humpNosedPitViperButton = findViewById<Button>(R.id.humpNosedPitViper_button);
        var ratSnakeButton = findViewById<Button>(R.id.ratSnake_button);
        var russellasViperButton = findViewById<Button>(R.id.russellasViper_button);
        var sawScaledViperButton = findViewById<Button>(R.id.sawScaledViper_button);
        var greenTreeVineButton = findViewById<Button>(R.id.greenTreeVine_button);
        var indianRockPythonButton = findViewById<Button>(R.id.indianRockPython_button);
        var commonSandBoaButton = findViewById<Button>(R.id.commonSandBoa_button);

        //functionality for Cobra, See More button
        cobraButton.setOnClickListener {
            var snakeId = "{\"snakeid\":\"62401ff856d67da73d2bbbbe\"}";               // id of the snake

            intent= Intent(this,SnakeActivity::class.java).also {
                sendRequest(snakeId);
                it.putExtra("FAMILY", family);
                it.putExtra("SCIENTIFIC_NAME", scientificName);
                it.putExtra("TOXICITY", type);
                it.putExtra("DESCRIPTION", desc);

                // Here(Line no:68-72) I added more detail other than
                // FAMILY,SCIENTIFIC_NAME...ect,
                // DESHAL please add fields to this details. N delete this comment
                it.putExtra("NAME", name);
                it.putExtra("SIZE", size);
                it.putExtra("WEIGHT", weight);
                it.putExtra("GENUS", genus);
                it.putExtra("COLOR", color);
                it.putExtra("VENOM_TYPE", venomType)
                it.putExtra("SNAKEID", "62401ff856d67da73d2bbbbe");
                startActivity(it)
            };
        };

        //functionality for Common Krait, See More button
        commonKraitButton.setOnClickListener {
            var snakeId = "{\"snakeid\":\"62403239bc4ea173bbc6296b\"}";                // id of the snake

            intent= Intent(this,SnakeActivity::class.java).also {
                sendRequest(snakeId);
                it.putExtra("FAMILY", family);
                it.putExtra("SCIENTIFIC_NAME", scientificName);
                it.putExtra("TOXICITY", type);
                it.putExtra("DESCRIPTION", desc);
                it.putExtra("NAME", name);
                it.putExtra("SIZE", size);
                it.putExtra("WEIGHT", weight);
                it.putExtra("GENUS", genus);
                it.putExtra("COLOR", color);
                it.putExtra("VENOM_TYPE", venomType)
                it.putExtra("SNAKEID", "62403239bc4ea173bbc6296b");
                startActivity(it)
            };
        };

        //functionality for HumpNosed PitViper, See More button
        humpNosedPitViperButton.setOnClickListener {
            var snakeId = "{\"snakeid\":\"62403383c92dc4ffbd9386d6\"}";                // id of the snake

            intent= Intent(this,SnakeActivity::class.java).also {
                sendRequest(snakeId);
                it.putExtra("FAMILY", family);
                it.putExtra("SCIENTIFIC_NAME", scientificName);
                it.putExtra("TOXICITY", type);
                it.putExtra("DESCRIPTION", desc);
                it.putExtra("NAME", name);
                it.putExtra("SIZE", size);
                it.putExtra("WEIGHT", weight);
                it.putExtra("GENUS", genus);
                it.putExtra("COLOR", color);
                it.putExtra("VENOM_TYPE", venomType)
                it.putExtra("SNAKEID", "62403383c92dc4ffbd9386d6");
                startActivity(it)
            };
        };

        //functionality for RatSnake, See More button
        ratSnakeButton.setOnClickListener {
            var snakeId = "{\"snakeid\":\"62403414c92dc4ffbd9386d8\"}";                // id of the snake

            intent= Intent(this,SnakeActivity::class.java).also {
                sendRequest(snakeId);
                it.putExtra("FAMILY", family);
                it.putExtra("SCIENTIFIC_NAME", scientificName);
                it.putExtra("TOXICITY", type);
                it.putExtra("DESCRIPTION", desc);
                it.putExtra("NAME", name);
                it.putExtra("SIZE", size);
                it.putExtra("WEIGHT", weight);
                it.putExtra("GENUS", genus);
                it.putExtra("COLOR", color);
                it.putExtra("VENOM_TYPE", venomType)
                it.putExtra("SNAKEID", "62403414c92dc4ffbd9386d8");
                startActivity(it)
            };
        };

        //functionality for Russellas Viper, See More button
        russellasViperButton.setOnClickListener {
            var snakeId = "{\"snakeid\":\"6240348dc92dc4ffbd9386da\"}";                // id of the snake

            intent= Intent(this,SnakeActivity::class.java).also {
                sendRequest(snakeId);
                it.putExtra("FAMILY", family);
                it.putExtra("SCIENTIFIC_NAME", scientificName);
                it.putExtra("TOXICITY", type);
                it.putExtra("DESCRIPTION", desc);
                it.putExtra("NAME", name);
                it.putExtra("SIZE", size);
                it.putExtra("WEIGHT", weight);
                it.putExtra("GENUS", genus);
                it.putExtra("COLOR", color);
                it.putExtra("VENOM_TYPE", venomType)
                it.putExtra("SNAKEID", "6240348dc92dc4ffbd9386da");
                startActivity(it)
            };
        };

        //functionality for SawScaled Viper, See More button
        sawScaledViperButton.setOnClickListener {
            var snakeId = "{\"snakeid\":\"62403516c92dc4ffbd9386dc\"}";                // id of the snake

            intent= Intent(this,SnakeActivity::class.java).also {
                sendRequest(snakeId);
                it.putExtra("FAMILY", family);
                it.putExtra("SCIENTIFIC_NAME", scientificName);
                it.putExtra("TOXICITY", type);
                it.putExtra("DESCRIPTION", desc);
                it.putExtra("NAME", name);
                it.putExtra("SIZE", size);
                it.putExtra("WEIGHT", weight);
                it.putExtra("GENUS", genus);
                it.putExtra("COLOR", color);
                it.putExtra("VENOM_TYPE", venomType)
                it.putExtra("SNAKEID", "62403516c92dc4ffbd9386dc");
                startActivity(it)
            };
        };

        //functionality for Green Tree Vine Snake, See More button
        greenTreeVineButton.setOnClickListener {
            var snakeId = "{\"snakeid\":\"6240359bc92dc4ffbd9386de\"}";                // id of the snake

            intent= Intent(this,SnakeActivity::class.java).also {
                sendRequest(snakeId);
                it.putExtra("FAMILY", family);
                it.putExtra("SCIENTIFIC_NAME", scientificName);
                it.putExtra("TOXICITY", type);
                it.putExtra("DESCRIPTION", desc);
                it.putExtra("NAME", name);
                it.putExtra("SIZE", size);
                it.putExtra("WEIGHT", weight);
                it.putExtra("GENUS", genus);
                it.putExtra("COLOR", color);
                it.putExtra("VENOM_TYPE", venomType)
                it.putExtra("SNAKEID", "6240359bc92dc4ffbd9386de");
                startActivity(it)
            };
        };

        //functionality for Indian RockPython, See More button
        indianRockPythonButton.setOnClickListener {
            var snakeId = "{\"snakeid\":\"62403620c92dc4ffbd9386e0\"}";                // id of the snake

            intent= Intent(this,SnakeActivity::class.java).also {
                sendRequest(snakeId);
                it.putExtra("FAMILY", family);
                it.putExtra("SCIENTIFIC_NAME", scientificName);
                it.putExtra("TOXICITY", type);
                it.putExtra("DESCRIPTION", desc);
                it.putExtra("NAME", name);
                it.putExtra("SIZE", size);
                it.putExtra("WEIGHT", weight);
                it.putExtra("GENUS", genus);
                it.putExtra("COLOR", color);
                it.putExtra("VENOM_TYPE", venomType)
                it.putExtra("SNAKEID", "62403620c92dc4ffbd9386e0");
                startActivity(it)
            };
        };

        //functionality for Common SandBoa, See More button
        commonSandBoaButton.setOnClickListener {
            var snakeId = "{\"snakeid\":\"624036a8c92dc4ffbd9386e2\"}";                // id of the snake

            intent= Intent(this,SnakeActivity::class.java).also {
                sendRequest(snakeId);
                it.putExtra("FAMILY", family);
                it.putExtra("SCIENTIFIC_NAME", scientificName);
                it.putExtra("TOXICITY", type);
                it.putExtra("DESCRIPTION", desc);
                it.putExtra("NAME", name);
                it.putExtra("SIZE", size);
                it.putExtra("WEIGHT", weight);
                it.putExtra("GENUS", genus);
                it.putExtra("COLOR", color);
                it.putExtra("VENOM_TYPE", venomType)
                it.putExtra("SNAKEID", "624036a8c92dc4ffbd9386e2");
                startActivity(it)
            };
        };
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

    // function to send the request via the service
    private fun sendRequest(snakeIdString: String){
        val client = OkHttpClient();                                                                // create instance of okhttp client

        val snakeId = snakeIdString;                                                                // id of the snake as a string

        val rq = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), snakeId); // create request body

        // build the request
        val request = Request.Builder()
            .url("http://172.16.1.35:8000/api/view_snakes")
            .method("POST", rq)
            .header("Content-Type", "application/json")
            .build();

        // send the request
        client.newCall(request).enqueue(object : Callback {
            // function to fire is the request was unable to send
            override fun onFailure(call: Call, e: IOException) {
                Log.d("IOException: ", e.message.toString() );
                Log.d("If failed to connect to the given ip address in the request url ", "find your current ip address and add it to the network_security.xml file and the request url.");
            };

            // function to fire is the request was sent and the response was received
            override fun onResponse(call: Call, res: Response) {
                Log.d("Check response:", "-------------------- response received --------------------");

                val snake = res.body()?.string();                                                   // converting response body to a String

                // check whether the response is empty or not
                if (snake != null) {
                    Log.d("Snake", snake);

                    val snakeObj = JSONObject(snake);                                               // converting response String to a jason object

                    setGlobalVar(snakeObj);
                };
            }
        })
    }

    // function to update global variables dynamically
    private fun setGlobalVar(snake: JSONObject){
        name = snake.getString("snakeName");
        scientificName = snake.getString("snakeScientificName");
        type = snake.getString("snakeType");
        size = snake.getString("snakeAvgSize");
        color = snake.getString("snakeColor");
        weight = snake.getString("Weight");
        family = snake.getString("Family");
        genus = snake.getString("Genus");
        venomType = snake.getString("snakeVenomType");
        desc = snake.getString("snakeDescription");

        Log.i("name2", name);
    }
}