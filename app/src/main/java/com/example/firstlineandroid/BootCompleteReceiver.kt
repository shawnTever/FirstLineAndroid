package com.example.firstlineandroid

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        /*
            静态监测广播
         */
        Toast.makeText(context, "Boot Complete", Toast.LENGTH_LONG).show()
        Log.d("Self-Boot", "Boot Complete")

    }
}