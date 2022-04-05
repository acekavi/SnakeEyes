package com.example.snakeeyes

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        var scientific_name=intent.getStringExtra("SCIENTIFIC_NAME")
        var family=intent.getStringExtra("FAMILY")
        var description=intent.getStringExtra("DESCRIPTION")
        var name=intent.getStringExtra("NAME")
        var size=intent.getStringExtra("SIZE")
        var weight=intent.getStringExtra("WEIGHT")
        var genus=intent.getStringExtra("GENUS")
        var color=intent.getStringExtra("COLOR")
        var venomType=intent.getStringExtra("VENOM_TYPE")
        var snakeId=intent.getStringExtra("SNAKEID")

        var toxicityLabel=findViewById<TextView>(R.id.toxiclabel)
        var sciName=findViewById<TextView>(R.id.scie_name)
        var snakeFamily=findViewById<TextView>(R.id.snakeFamilyName)
        var snake_Desc=findViewById<TextView>(R.id.desc_text)
        var label=findViewById<CardView>(R.id.card_toxiclabel)
        var snakeName = findViewById<TextView>(R.id.snakes_name)
        var snakeSize = findViewById<TextView>(R.id.snkeSize)
        var snakeWeight = findViewById<TextView>(R.id.snakWeight)
        var snakeGenue = findViewById<TextView>(R.id.snke_genus)
        var snakeColor = findViewById<TextView>(R.id.snakeColr)
        var snakeVenomType = findViewById<TextView>(R.id.snakeVenomTyp)

        //adding snake toxicity according to type in CommonSnake -> SeeMore
        if(toxicity.toString().equals("Venomous")){
            label.getBackground().setTint(Color.parseColor("#FB6767"))
        }
        else if(toxicity.toString().equals("Non-Venomous")){
            label.getBackground().setTint(Color.parseColor("#90EE90"))
        }
        else if(toxicity.toString().equals("Mildly-Venomous")){
            label.getBackground().setTint(Color.parseColor("#fc8128"))
        }
        else{
            Log.d("ERROR: ","Could not generate the Toxicity!");
        }

        //adding snake images in CommonSnake -> SeeMore
        if(snakeId.toString().equals("62401ff856d67da73d2bbbbe")){
            var image = findViewById(R.id.snakeImage) as ImageView
            image.setImageResource(R.drawable.cobra);
        }
        else if(snakeId.toString().equals("62403239bc4ea173bbc6296b")){
            var image = findViewById(R.id.snakeImage) as ImageView
            image.setImageResource(R.drawable.commonkrait);
        }
        else if(snakeId.toString().equals("62403383c92dc4ffbd9386d6")){
            var image = findViewById(R.id.snakeImage) as ImageView
            image.setImageResource(R.drawable.humpnosedpitviper);
        }
        else if(snakeId.toString().equals("62403414c92dc4ffbd9386d8")){
            var image = findViewById(R.id.snakeImage) as ImageView
            image.setImageResource(R.drawable.ratsnake);
        }
        else if(snakeId.toString().equals("6240348dc92dc4ffbd9386da")){
            var image = findViewById(R.id.snakeImage) as ImageView
            image.setImageResource(R.drawable.rusellasviper);
        }
        else if(snakeId.toString().equals("62403516c92dc4ffbd9386dc")){
            var image = findViewById(R.id.snakeImage) as ImageView
            image.setImageResource(R.drawable.sawscaledviper);
        }
        else if(snakeId.toString().equals("6240359bc92dc4ffbd9386de")){
            var image = findViewById(R.id.snakeImage) as ImageView
            image.setImageResource(R.drawable.greentreevine);
        }
        else if(snakeId.toString().equals("62403620c92dc4ffbd9386e0")){
            var image = findViewById(R.id.snakeImage) as ImageView
            image.setImageResource(R.drawable.indianrockpython);
        }
        else if(snakeId.toString().equals("624036a8c92dc4ffbd9386e2")){
            var image = findViewById(R.id.snakeImage) as ImageView
            image.setImageResource(R.drawable.commonsandboa);
        }
        else{
            Log.d("ERROR: ","Image could not download due to an error!");
        }






        //  toxicityLabel.setBackgroundColor(getResources().getColor(R.color.purple_200));
        sciName.text=scientific_name.toString()
        snakeFamily.text=family.toString()
        snake_Desc.text=description.toString()
        toxicityLabel.text=toxicity.toString()
        snakeName.text = name.toString()
        snakeSize.text = size.toString()
        snakeWeight.text = weight.toString()
        snakeGenue.text = genus.toString()
        snakeColor.text = color.toString()
        snakeVenomType.text = venomType.toString()

      //  toxicityLabel.backgroundTintList = ColorStateList.valueOf(R.color.teal_200)










    }
}