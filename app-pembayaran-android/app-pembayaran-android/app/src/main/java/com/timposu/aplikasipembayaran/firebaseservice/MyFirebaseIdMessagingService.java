package com.timposu.aplikasipembayaran.firebaseservice;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by ucup on 14/08/17.
 */

public class MyFirebaseIdMessagingService extends FirebaseInstanceIdService {

    private static final String TAG = "NOTIFIKASI";

    @Override
    public void onTokenRefresh() {

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "token = " + token);

    }
}
