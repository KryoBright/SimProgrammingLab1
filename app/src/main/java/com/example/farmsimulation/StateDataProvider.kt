package com.example.farmsimulation

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.widget.EditText
import androidx.core.graphics.drawable.toDrawable

class StateDataProvider {
    companion object{
        fun getStateLength(state:Int): Int {
            var smp=0.01
            if (state==1)
            {
                return (2000*smp).toInt()
            }
            if (state==2)
            {
                return (10000*smp).toInt()
            }
            if (state==3)
            {
                return (14000*smp).toInt()
            }
            if (state==4)
            {
                return (16000*smp).toInt()
            }
            return 0;
        }

        fun getStateCost(state:Int): Int {
            if (state==0)
            {
                return -2
            }
            if (state==1)
            {
                return 0
            }
            if (state==2)
            {
                return 1
            }
            if (state==3)
            {
                return 3
            }
            if (state==4)
            {
                return 5
            }
            return -1
        }

        fun getStateDrawable(state:Int): Drawable {
            if (state==0)
            {
                return Color.WHITE.toDrawable()
            }
            if (state==1)
            {
                return Color.BLACK.toDrawable()
            }
            if (state==2)
            {
                return Color.GREEN.toDrawable()
            }
            if (state==3)
            {
                return Color.YELLOW.toDrawable()
            }
            if (state==4)
            {
                return Color.RED.toDrawable()
            }
            return (Color.rgb(150,100,0)).toDrawable()
        }
    }
}