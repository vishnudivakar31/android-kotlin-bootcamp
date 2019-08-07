package com.wanderingthinkter.tipcal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateTip.setOnClickListener {
            var amount = amount.text.toString().toDouble()
            val percentage = tipPercentage.text.toString().toDouble()
            val tip = round(((percentage / 100) * amount) * 100) / 100
            amount += tip
            var resultTxt = getString(R.string.result).replace("{0}", tip.toString())
            resultTxt = resultTxt.replace("{1}", amount.toString())
            result.text = resultTxt
        }
    }
}
