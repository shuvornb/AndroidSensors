package com.ecit.androidsensors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        btnShowData.setOnClickListener {
            var locationDataProvider = LocationDataProvider()
            val locationData = locationDataProvider.fetchLocationData(this, this)

            txtViewLat.text = locationData.split(" ")[0]
            txtViewLong.text = locationData.split(" ")[1]
        }
    }
}
