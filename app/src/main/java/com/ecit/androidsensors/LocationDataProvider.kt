package com.ecit.androidsensors

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.LocationManager
import androidx.core.app.ActivityCompat


class LocationDataProvider {

    fun fetchLocationData(context : Context, activity : Activity) : String {

        var locationData = "Permission denied"

        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED) {
            return locationData
        }

        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED) {
            return locationData
        }

        val locationManager = activity.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val criteria = Criteria()
        val bestProvider = locationManager.getBestProvider(criteria, false)
        val location = locationManager.getLastKnownLocation(bestProvider!!)
        try {
            locationData =  location!!.latitude.toString() + " " + location.longitude.toString()
        } catch (e: NullPointerException) {
            locationData =  "No location data found"
        }

        return locationData
    }
}