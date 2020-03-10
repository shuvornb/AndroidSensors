package com.ecit.androidsensors

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        btnCamera.setOnClickListener {
            var intent = Intent(this, ImageActivity::class.java)
            startActivity(intent)
        }

        btnGPS.setOnClickListener {
            var gpsIntent = Intent(this, GPSActivity::class.java)
            startActivity(gpsIntent)
        }
    }
}
