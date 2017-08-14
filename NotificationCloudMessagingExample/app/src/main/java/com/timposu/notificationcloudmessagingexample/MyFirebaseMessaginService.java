package com.timposu.notificationcloudmessagingexample;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by ucup on 8/12/17.
 */

public class MyFirebaseMessaginService extends FirebaseMessagingService {

    private static final String TAG = "NOTIFIKASI";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        String from = remoteMessage.getFrom();
        Log.d(TAG, "Message from : " + from);

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Notifikasi : " + remoteMessage.getNotification().getBody());
        }
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Data : " + remoteMessage.getData());
        }

    }

}
