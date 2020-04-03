package com.ecit.androidsensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.CUPCAKE)


class AccelerometerSensor(
    var xdir: Float,
    var ydir: Float,
    var zdir: Float,
    mContext: Context
) : SensorEventListener{
    private var context:Context = mContext
    //fun AccelerometerSensor(x,y,z,context: Context){}
    private var sensorManager : SensorManager ?= null
    private var sensor : Sensor?= null
    init{
        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager!!.registerListener(this,
            sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null && event.values.isNotEmpty()) {
            xdir = event.values?.get(0)!!
            ydir = event.values?.get(1)!!
            zdir = event.values?.get(2)!!
            println("values are $xdir $ydir $zdir")
            // MainActivity. setAccelerometer(this)
        }
    }



}
