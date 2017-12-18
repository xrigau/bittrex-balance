package com.gbasile.bittrexbalance

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.concurrent.TimeUnit

class BitTrexAlarmManager(
        private val context: Context,
        private val alarmManager: AlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
) {
    fun setup(value: Long, timeUnit: TimeUnit) {
        val interval = timeUnit.toMillis(value)
        val intent = Intent(context, RefreshBalanceReceiver::class.java)

        alarmManager.setInexactRepeating(
                AlarmManager.RTC,
                0,
                interval,
                PendingIntent.getBroadcast(context, ALARM_REQUEST_CODE, intent, 0)
        )
    }

    companion object {
        val ALARM_REQUEST_CODE = 4242
    }

}
