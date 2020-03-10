package com.ecit.androidsensors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_gps.*

class GPSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_gps)

        btnDisplayLatLng.setOnClickListener {
            var locationDataProvider = LocationDataProvider()
            val locationData = locationDataProvider.fetchLocationData(this, this)
            txtViewRawLoc.text = locationData
        }
    }
}