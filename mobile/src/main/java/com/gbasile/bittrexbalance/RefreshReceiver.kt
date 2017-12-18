package com.gbasile.bittrexbalance

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.util.*

class RefreshBalanceReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.e("FOO", "running")
        val notificationManager = BitTrexNotificationManager(context)
        val randomString = Random().nextDouble().toString()
        notificationManager.showNotification(randomString)
    }

}
