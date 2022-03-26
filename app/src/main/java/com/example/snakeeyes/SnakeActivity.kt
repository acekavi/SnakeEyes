package com.example.snakeeyes

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SnakeActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_snake)

     var toxicity=intent.getStringExtra("TOXICITY")
        var family=intent.getStringExtra("FAMILY")
        var scientific_name=intent.getStringExtra("SCIENTIFIC_NAME")
        var description=intent.getStringExtra("DESCRIPTION")

     var toxicityLabel=findViewById<TextView>(R.id.toxiclabel)
        var sciName=findViewById<TextView>(R.id.scie_name)
        var Snakefamily=findViewById<TextView>(R.id.snakeName)
        var snake_Desc=findViewById<TextView>(R.id.desc_text)


      //  toxicityLabel.setBackgroundColor(getResources().getColor(R.color.purple_200));
        sciName.text="Scientific Name : "+scientific_name.toString()
        Snakefamily.text="Family  :"+family.toString()
        snake_Desc.text=description.toString()
        toxicityLabel.text=toxicity.toString()









    }
}