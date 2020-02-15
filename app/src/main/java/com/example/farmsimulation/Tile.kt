package com.example.farmsimulation

import android.view.View
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Tile(v1:View):Updatable {
    private var v=v1
    private var state=0
    private var lifetime=0
    init {
        v.setOnClickListener {
            if (state==0)
            {
                plant()
            }
            else harvest()
        }
    }

    override fun update()
    {
        if ((state>0)&&(state<5))
        {
            lifetime++
            if (lifetime>StateDataProvider.getStateLength(state))
            {
                state++
                updateView()
            }
        }
        else {
            updateView()
        }
    }

    private fun updateView()
    {
        GlobalScope.launch {
            withContext(Dispatchers.Main)
            {
                v.background = StateDataProvider.getStateDrawable(state)
            }
        }
    }

    fun plant()
    {
        MoneyBag.stonksChange(StateDataProvider.getStateCost(state))
        state=1
        updateView()
        lifetime=0
    }

    fun harvest()
    {
        MoneyBag.stonksChange(StateDataProvider.getStateCost(state))
        state=0
        updateView()
    }
}