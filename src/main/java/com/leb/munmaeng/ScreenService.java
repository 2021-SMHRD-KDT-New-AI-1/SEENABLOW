package com.leb.munmaeng;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;


public class ScreenService extends Service {
    private ScreenReceiver mReceiver = null;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mReceiver = new ScreenReceiver();
        IntentFilter filter =new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mReceiver, filter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if(intent != null){
            if(intent.getAction() == null){
             if(mReceiver ==null){
                 mReceiver = new ScreenReceiver();
                 IntentFilter filter =new IntentFilter(Intent.ACTION_SCREEN_OFF);
                 registerReceiver(mReceiver, filter);
             }
            }
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mReceiver !=null ){
            unregisterReceiver(mReceiver);
        }
    }
}
