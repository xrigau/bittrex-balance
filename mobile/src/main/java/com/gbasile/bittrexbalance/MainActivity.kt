package com.gbasile.bittrexbalance

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var notificationManager: BitTrexNotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = BitTrexNotificationManager(this)
        notificationManager.registerChannels()

        val bitTrexAlarmManager = BitTrexAlarmManager(this)
        bitTrexAlarmManager.setup(1, TimeUnit.MINUTES)
    }

}

