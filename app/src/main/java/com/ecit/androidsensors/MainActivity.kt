package com.ecit.androidsensors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val accelerometer = AccelerometerSensor(0.0f, 0.0f, 0.0f,this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        btnShowData.setOnClickListener {
            //comment
               setAccelerometer(accelerometer.xdir.toString(),accelerometer.ydir.toString(),accelerometer.zdir.toString())
                //checkChange()
        }

    }
    open fun setAccelerometer(x:String, y:String, z:String){
        txtViewX.text = "Angular speed in X direction : $x"
        txtViewY.text = "Angular speed in Y direction : $y"
        txtViewZ.text = "Angular speed in Z direction : $z"
    }

}
