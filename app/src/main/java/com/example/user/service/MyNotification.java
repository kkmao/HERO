package com.example.user.service;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by User on 2017/7/12.
 */

public class MyNotification {

//    final int notifyID = 1; // 通知的識別號碼
//    final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
//    final Notification notification = new Notification.Builder()
//            .setSmallIcon(R.drawable.bomb).setContentTitle("內容標題").setContentText("內容文字").build(); // 建立通知
//    notificationManager.notify(notifyID,notification); // 發送通知

//    NotificationCompat.Builder mBuilder =
//            new NotificationCompat.Builder(this)
//                    .setSmallIcon(R.drawable.bomb)
//                    .setWhen(System.currentTimeMillis())
//                    .setContentTitle("My notification")
//                    .setContentText("Hello World!");
//    Intent resultIntent = new Intent(this, MyService.class);
//
//    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//    // Adds the back stack for the Intent (but not the Intent itself)
//    stackBuilder.addParentStack(ResultActivity.class);
//    // Adds the Intent that starts the Activity to the top of the stack
//    stackBuilder.addNextIntent(resultIntent);
//    PendingIntent resultPendingIntent =
//            stackBuilder.getPendingIntent(
//                    0,
//                    PendingIntent.FLAG_UPDATE_CURRENT
//            );
//    mBuilder.setContentIntent(resultPendingIntent);
//    NotificationManager mNotificationManager =
//            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//    // mId allows you to update the notification later on.
//    mNotificationManager.notify(mId,mBuilder.build());
}
