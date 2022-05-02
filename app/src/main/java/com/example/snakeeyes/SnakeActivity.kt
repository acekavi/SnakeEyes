package com.example.snakeeyes

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.example.snakeeyes.R
import android.widget.TextView
import androidx.cardview.widget.CardView
import java.lang.NullPointerException
import kotlin.jvm.internal.Intrinsics

class SnakeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val var10000 = this.supportActionBar
        var10000?.hide()
        this.setContentView(R.layout.activity_snake)
        val toxicity = this.intent.getStringExtra("TOXICITY")
        val scientific_name = this.intent.getStringExtra("SCIENTIFIC_NAME")
        val family = this.intent.getStringExtra("FAMILY")
        val description = this.intent.getStringExtra("DESCRIPTION")
        val name = this.intent.getStringExtra("NAME")
        val size = this.intent.getStringExtra("SIZE")
        val weight = this.intent.getStringExtra("WEIGHT")
        val genus = this.intent.getStringExtra("GENUS")
        val color = this.intent.getStringExtra("COLOR")
        val venomType = this.intent.getStringExtra("VENOM_TYPE")
        val snakeId = this.intent.getStringExtra("SNAKEID")
        val toxicityLabel = findViewById<View>(R.id.toxiclabel) as TextView
        val sciName = findViewById<View>(R.id.scie_name) as TextView
        val snakeFamily = findViewById<View>(R.id.snakeFamilyName) as TextView
        val snake_Desc = findViewById<View>(R.id.desc_text) as TextView
        val label = findViewById<View>(R.id.card_toxiclabel) as CardView
        val snakeName = findViewById<View>(R.id.snakes_name) as TextView
        val snakeSize = findViewById<View>(R.id.snkeSize) as TextView
        val snakeWeight = findViewById<View>(R.id.snakeVenomTyp) as TextView
        val snakeGenue = findViewById<View>(R.id.snakeColr) as TextView
        val snakeColor = findViewById<View>(R.id.snke_genus) as TextView
        val snakeVenomType = findViewById<View>(R.id.snakeVenomTyp) as TextView
        if (toxicity.toString() == "Venomous") {
            label.background.setTint(Color.parseColor("#FB6767"))
        } else if (toxicity.toString() == "Non-Venomous") {
            label.background.setTint(Color.parseColor("#90EE90"))
        } else if (toxicity.toString() == "Mildly-Venomous") {
            label.background.setTint(Color.parseColor("#fc8128"))
        } else {
            Log.d("ERROR: ", "Could not generate the Toxicity!")
        }
        val image: ImageView
        val var25: View?
        if (snakeId.toString() == "62401ff856d67da73d2bbbbe") {
            var25 = findViewById(R.id.snakeImage)
            if (var25 == null) {
                throw NullPointerException("null cannot be cast to non-null type android.widget.ImageView")
            }
            image = var25 as ImageView
            image.setImageResource(R.drawable.cobra)
        } else if (snakeId.toString() == "62403239bc4ea173bbc6296b") {
            var25 = findViewById(R.id.snakeImage)
            if (var25 == null) {
                throw NullPointerException("null cannot be cast to non-null type android.widget.ImageView")
            }
            image = var25 as ImageView
            image.setImageResource(R.drawable.commonkrait)
        } else if (snakeId.toString() == "62403383c92dc4ffbd9386d6") {
            var25 = findViewById(R.id.snakeImage)
            if (var25 == null) {
                throw NullPointerException("null cannot be cast to non-null type android.widget.ImageView")
            }
            image = var25 as ImageView
            image.setImageResource(R.drawable.humpnosedpitviper)
        } else if (snakeId.toString() == "62403414c92dc4ffbd9386d8") {
            var25 = findViewById(R.id.snakeImage)
            if (var25 == null) {
                throw NullPointerException("null cannot be cast to non-null type android.widget.ImageView")
            }
            image = var25 as ImageView
            image.setImageResource(R.drawable.ratsnake)
        } else if (snakeId.toString() == "6240348dc92dc4ffbd9386da") {
            var25 = findViewById(R.id.snakeImage)
            if (var25 == null) {
                throw NullPointerException("null cannot be cast to non-null type android.widget.ImageView")
            }
            image = var25 as ImageView
            image.setImageResource(R.drawable.rusellasviper)
        } else if (snakeId.toString() == "62403516c92dc4ffbd9386dc") {
            var25 = findViewById(R.id.snakeImage)
            if (var25 == null) {
                throw NullPointerException("null cannot be cast to non-null type android.widget.ImageView")
            }
            image = var25 as ImageView
            image.setImageResource(R.drawable.sawscaledviper)
        } else if (snakeId.toString() == "6240359bc92dc4ffbd9386de") {
            var25 = findViewById(R.id.snakeImage)
            if (var25 == null) {
                throw NullPointerException("null cannot be cast to non-null type android.widget.ImageView")
            }
            image = var25 as ImageView
            image.setImageResource(R.drawable.greentreevine)
        } else if (snakeId.toString() == "62403620c92dc4ffbd9386e0") {
            var25 = findViewById(R.id.snakeImage)
            if (var25 == null) {
                throw NullPointerException("null cannot be cast to non-null type android.widget.ImageView")
            }
            image = var25 as ImageView
            image.setImageResource(R.drawable.indianrockpython)
        } else if (snakeId.toString() == "624036a8c92dc4ffbd9386e2") {
            var25 = findViewById(R.id.snakeImage)
            if (var25 == null) {
                throw NullPointerException("null cannot be cast to non-null type android.widget.ImageView")
            }
            image = var25 as ImageView
            image.setImageResource(R.drawable.commonsandboa)
        } else {
            Log.d("ERROR: ", "Image could not download due to an error!")
        }
        Intrinsics.checkNotNullExpressionValue(sciName, "sciName")
        sciName.text = scientific_name.toString()
        Intrinsics.checkNotNullExpressionValue(snakeFamily, "snakeFamily")
        snakeFamily.text = family.toString()
        Intrinsics.checkNotNullExpressionValue(snake_Desc, "snake_Desc")
        snake_Desc.text = description.toString()
        Intrinsics.checkNotNullExpressionValue(toxicityLabel, "toxicityLabel")
        toxicityLabel.text = toxicity.toString()
        Intrinsics.checkNotNullExpressionValue(snakeName, "snakeName")
        snakeName.text = name.toString()
        Intrinsics.checkNotNullExpressionValue(snakeSize, "snakeSize")
        snakeSize.text = size.toString()
        Intrinsics.checkNotNullExpressionValue(snakeWeight, "snakeWeight")
        snakeWeight.text = weight.toString()
        Intrinsics.checkNotNullExpressionValue(snakeGenue, "snakeGenue")
        snakeGenue.text = genus.toString()
        Intrinsics.checkNotNullExpressionValue(snakeColor, "snakeColor")
        snakeColor.text = color.toString()
        Intrinsics.checkNotNullExpressionValue(snakeVenomType, "snakeVenomType")
        snakeVenomType.text = venomType.toString()
    }
}