package com.app.myquestiontest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Observable;

public class MyReciver extends BroadcastReceiver {

    GetValueInterface getValueInterface;

    @Override
    public void onReceive(Context context, Intent intent) {

        //getValueInterface = (GetValueInterface)this;
        String iData = (String)intent.getExtras().get("iData");
        Log.d(">>>RECEIVED--",""+iData);
        //getValueInterface.getValueFrom(iData);

        GetValueInterface getValueInterface = new MainActivity();
        getValueInterface.getValueFrom(iData);
    }


}
