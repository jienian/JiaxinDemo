package com.jiaxin.browser.service;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class AdService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        checkForAdsAndNotify();
        return START_STICKY;
    }

    private void checkForAdsAndNotify() {
        String adTitle = "推广";

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "ID")
                .setContentTitle(adTitle)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        notificationManager.notify(1, builder.build());
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
