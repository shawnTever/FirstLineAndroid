package com.example.firstlineandroid

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver
    lateinit var br: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            显式intent
         */

//        val intent = Intent(this, FirstLine::class.java)
//        startActivity(intent)

        /*
            隐式intent
         */

//        val intent = Intent("com.example.activitytest.ACTION_START")
//        startActivity(intent)


        /*
            动态监测广播
         */

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_MANAGE_NETWORK_USAGE)
        }
        br = MyBroadcastReceiver()
        registerReceiver(br, filter)

        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)


        /*
            发送广播
         */

        SendBroadcast.setOnClickListener {
            val intent = Intent("com.example.firstlineandroid.My_BROADCAST")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
        unregisterReceiver(br)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
        }

    }

}