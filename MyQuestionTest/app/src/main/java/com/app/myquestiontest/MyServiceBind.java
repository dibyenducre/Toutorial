package com.app.myquestiontest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyServiceBind extends Service {

    @Override
    public IBinder onBind(Intent intent) {

        Log.d(">>MyService--","onBind");

        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d(">>MyService--","onStart");
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.d(">>MyService--","onUnbind");

        return super.onUnbind(intent);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(">>MyService--","onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(">>MyService--","onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(">>MyService--","onCreate");

    }


    public class MyBinder extends Binder {
        MyServiceBind getService() {
            return MyServiceBind.this;
        }
    }

}
