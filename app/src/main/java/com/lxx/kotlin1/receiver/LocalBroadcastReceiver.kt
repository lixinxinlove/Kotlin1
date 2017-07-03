package com.lxx.kotlin1.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class LocalBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.e("lee",intent.action)

        if(intent.action.equals("com.lxx.kotlin1.lee")){

          //  Toast.makeText(context,"收到广播",Toast.LENGTH_SHORT).show()

        }
    }
}
