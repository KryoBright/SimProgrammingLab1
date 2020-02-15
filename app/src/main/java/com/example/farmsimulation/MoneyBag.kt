package com.example.farmsimulation

import android.widget.TextView

class MoneyBag() {
    companion object {
        private var stonks = 200
        lateinit var text:TextView
        fun stonksChange(am: Int) {
            stonks += am
        }

        fun update() {
            text.text = stonks.toString()
        }
    }
}