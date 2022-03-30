package com.example.snakeeyes

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

class SnakeActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n", "ResourceAsColor")
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
        var label=findViewById<CardView>(R.id.card_toxiclabel)



        if(toxicity.toString().equals("HIGHLY-VENOMOUS")){
            label.getBackground().setTint(Color.parseColor("#FB6767"))

        }
        else if(toxicity.toString().equals("NON-VENOMOUS")){
            label.getBackground().setTint(Color.parseColor("#90EE90"))
        }
        else{
            label.getBackground().setTint(Color.parseColor("#FFBA4B"))
        }

        var image = findViewById(R.id.snakeImage) as ImageView
        image.setImageResource(R.drawable.commonkrait);






        //  toxicityLabel.setBackgroundColor(getResources().getColor(R.color.purple_200));
        sciName.text=scientific_name.toString()
        Snakefamily.text=family.toString()
        snake_Desc.text=description.toString()
        toxicityLabel.text=toxicity.toString()

      //  toxicityLabel.backgroundTintList = ColorStateList.valueOf(R.color.teal_200)










    }
}