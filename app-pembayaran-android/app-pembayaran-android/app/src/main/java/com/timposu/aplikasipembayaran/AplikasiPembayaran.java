package com.timposu.aplikasipembayaran;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Ucup on 01/08/2017.
 */

public class AplikasiPembayaran extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
