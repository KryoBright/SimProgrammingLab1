package com.example.farmsimulation

import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.concurrent.schedule

class TimeEmulator(itiles:List<Tile>,timeText:EditText,itext: TextView) {
    var timer=Timer()
    var timeSteps=0
    var tiles=itiles
    var text=itext
    var time=timeText
    init {
       step()
    }

    fun step()
    {
        var delay=("0"+time.text.toString()).toInt()
        if (delay==0){delay+=10}
        timer.schedule(object :TimerTask(){
            override fun run() {
                timeSteps++
                var i=0
                while (i<tiles.size)
                {
                    tiles[i].update()
                    i++
                }
                GlobalScope.launch {
                    withContext(Dispatchers.Main)
                    {
                        MoneyBag.update()
                        text.text=timeSteps.toString()
                    }
                }
                step()
            }
        },delay.toLong())
    }
}