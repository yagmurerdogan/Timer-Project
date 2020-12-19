package com.yagmurerdgn.timerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = 0
    var runnable : Runnable = Runnable {  }
    var handler = Handler(Looper.myLooper()!!)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun startCounter(view : View){
        number = 0
        runnable = object  : Runnable{
            override fun run() {
                number = number + 1
                textView.text = "☁ ${number} ☁"
                handler.postDelayed(runnable,1000)
            }

        }
        handler.post(runnable)

    }

    fun resetCounter(view : View) {
        handler.removeCallbacks(runnable)
        number = 0
        textView.text = "☁  0  ☁"

    }

    fun stopCounter(view: View){
        handler.removeCallbacks(runnable)
        //number = number
        textView.text = "☁ ${number} ☁"
    }

    fun resumeCounter(view: View) {
        handler.post(runnable)
    }

}