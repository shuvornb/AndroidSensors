package com.ecit.androidsensors

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.LocationManager
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


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

    fun fetchLocationDetails(txtViewDetails: TextView, context: Context, latitude: String, longitude: String) {
        val queue = Volley.newRequestQueue(context)
        val url =
            "https://api.opencagedata.com/geocode/v1/json?key=51024d238e8448149b041b0238a581c7&q=$latitude%2C+,$longitude&pretty=1&no_annotations=1"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                txtViewDetails.text = response
            },
            Response.ErrorListener { txtViewDetails.text = "That didn't work!" })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}