package sk.mtaa.xremenarp.xmatusiskova

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import android.os.Handler
import android.os.Looper
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.core.app.NotificationManagerCompat

fun showNotification(context: Context, title: String,message: String, id: Int) {
    val channelId = "visitor"
    val channelName = "Visitor"

    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.logo)
        .setContentTitle(title)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(channel)
    }
    notificationManager.notify(id, builder.build())
    scheduleNotifications(context)
}

fun scheduleNotifications(context: Context) {
    var id = 2
    val handler = Handler(Looper.getMainLooper())
    val delay = 10000L
    val notificationRunnable = object : Runnable {
        override fun run() {
            id++
            showNotification(context, "10 sec nothification","10",id)
            handler.postDelayed(this, delay)
        }
    }
    handler.postDelayed(notificationRunnable, delay)
}