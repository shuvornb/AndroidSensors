package com.ecit.androidsensors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_gps.*

class GPSActivity : AppCompatActivity() {
    var latitude = ""
    var longitude = ""
    var locationDataProvider = LocationDataProvider()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_gps)

        btnDisplayLatLng.setOnClickListener {
            val locationData = locationDataProvider.fetchLocationData(this, this)
            txtViewRawLoc.text = locationData
            latitude = locationData.split(" ")[0]
            longitude = locationData.split(" ")[1]
        }

        btnDisplayDetails.setOnClickListener {
            locationDataProvider.fetchLocationDetails(txtViewLocDetails, this, latitude, longitude)
        }
    }
}