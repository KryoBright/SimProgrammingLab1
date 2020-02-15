package com.example.farmsimulation

import android.content.pm.ActivityInfo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MoneyBag.text=findViewById(R.id.textViewMoney)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val height = displayMetrics.heightPixels-50
        val width = displayMetrics.widthPixels
        val viewList= ArrayList<View>()
        var tileList= ArrayList<Tile>()
        var i=0
        while(i<16)
        {
            val vTmp= View(this)
            val params : LayoutParams = LayoutParams(
                width/4, // This will define text view width
                (height-100)/5)
            vTmp.layoutParams=params
            vTmp.y=((height-100)*(i/4+1))/5.0F
            vTmp.x=(width*(i%4))/4.0F
            layoutView.addView(vTmp)
            viewList.add(vTmp)
            val tileTmp=Tile(vTmp)
            tileList.add(tileTmp)
            i++;
        }
        var time=TimeEmulator(tileList,editTextSpeed,textViewTime)
    }
}
