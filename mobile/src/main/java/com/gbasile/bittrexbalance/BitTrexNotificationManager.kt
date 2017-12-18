package com.gbasile.bittrexbalance

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context

class BitTrexNotificationManager(
        private val context: Context,
        private val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
) {

    fun registerChannels() {
        val channel = NotificationChannel(NOTIFICATION_CHANNEL, "Balance", NotificationManager.IMPORTANCE_DEFAULT)
        channel.setShowBadge(false)
        notificationManager.createNotificationChannel(channel)
    }

    fun showNotification(balance: String) {
        val builder = Notification.Builder(context, NOTIFICATION_CHANNEL)
        builder.setSmallIcon(android.R.drawable.ic_menu_add)
        builder.setContentTitle("BitTrex Balance: $balance BTC")
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    companion object {
        const val NOTIFICATION_ID = 12345
        const val NOTIFICATION_CHANNEL = "bittrex-balance"
    }
}
