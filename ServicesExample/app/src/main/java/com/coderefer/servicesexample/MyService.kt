package com.coderefer.servicesexample

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi


private val notificationId = 204858
private val CHANNEL_ID = "204858"
private val CHANNEL_NAME = "test channel name"

class MyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        val pendingIntent: PendingIntent =
            Intent(this, MainActivity::class.java).let {
                PendingIntent.getActivity(this, 0, it, 0)
            }
        val notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getNotification(pendingIntent)
        } else {
            getNotificationForOlderDevices(pendingIntent)
        }
        startForeground(notificationId, notification)
        return START_REDELIVER_INTENT
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private fun getNotificationForOlderDevices(pendingIntent: PendingIntent): Notification {
        return Notification.Builder(this)
            .setContentTitle(getText(R.string.notification_title))
            .setContentText(getText(R.string.notification_message))
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            .setTicker(getText(R.string.ticker_text))
            .build()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun getNotification(pendingIntent: PendingIntent): Notification {
        createNotificationChannel()
        return Notification.Builder(this, "main_channel")
            .setChannelId(CHANNEL_ID)
            .setContentTitle(getText(R.string.notification_title))
            .setContentText(getText(R.string.notification_message))
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            .setTicker(getText(R.string.ticker_text))
            .build()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(): NotificationChannel {
        val chan = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH
        )
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(chan)
        return chan
    }

    override fun stopService(name: Intent?): Boolean {
        return super.stopService(name)
    }

}
