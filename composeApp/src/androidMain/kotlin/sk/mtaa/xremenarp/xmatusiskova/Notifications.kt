package sk.mtaa.xremenarp.xmatusiskova

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import android.os.Handler
import android.os.Looper

fun showNotification(context: Context, title: String,message: String) {
    val channelId = "default_channel_id"
    val channelName = "Default Channel"
    val notificationId = 1

    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.logo)
        .setContentTitle(title)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // Create a notification channel
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(channel)
    }
    notificationManager.notify(notificationId, builder.build())
    scheduleNotifications(context)
}

fun scheduleNotifications(context: Context) {
    val handler = Handler(Looper.getMainLooper())
    val delayMillis = 10000L
    val notificationRunnable = object : Runnable {
        override fun run() {
            showNotification(context, "10 sec nothification","10")
            handler.postDelayed(this, delayMillis)
        }
    }
    handler.postDelayed(notificationRunnable, delayMillis)
}

