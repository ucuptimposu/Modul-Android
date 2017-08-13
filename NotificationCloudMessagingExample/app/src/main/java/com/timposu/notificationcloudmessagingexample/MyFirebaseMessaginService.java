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
            createNotification(remoteMessage.getNotification().getTitle(),
                    remoteMessage.getNotification().getBody());
        }
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Data : " + remoteMessage.getData());
        }

    }

    private void createNotification(String title, String body) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri notifSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notifBuild = new NotificationCompat.Builder(this).
                setSmallIcon(R.drawable.ic_stat_name).
                setContentTitle("Test").
                setContentText(body).
                setAutoCancel(true).
                setSound(notifSoundUri).
                setContentIntent(pendingIntent);
        Log.d(TAG, "title" + title);
        Log.d(TAG, "body" + body);

        NotificationManager notificationManager = (NotificationManager) getSystemService
                (Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notifBuild.build());
    }

}
