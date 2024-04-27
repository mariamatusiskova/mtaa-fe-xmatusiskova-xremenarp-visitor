package sk.mtaa.xremenarp.xmatusiskova

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import android.os.Handler
import android.os.Looper

fun showNotification(context: Context, title: String,message: String, id: Int) {
    val builder = NotificationCompat.Builder(context, "Visitor")
        .setSmallIcon(R.drawable.logo)
        .setContentTitle(title)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel("Visitor", "Visitor", NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(channel)
    }
    notificationManager.notify(id, builder.build())
}

fun scheduleNotifications(context: Context) {
    val handler = Handler(Looper.getMainLooper())
    val delay = 43200000L
    val notificationRunnable = object : Runnable {
        override fun run() {
            showNotification(context, "Visitor","Let's go somewhere!",3)
            handler.postDelayed(this, delay)
        }
    }
    showNotification(context, "Visitor","Let's go somewhere!",3)
    handler.postDelayed(notificationRunnable, delay)
}