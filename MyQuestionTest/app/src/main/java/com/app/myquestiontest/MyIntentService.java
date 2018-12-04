package com.app.myquestiontest;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        String iData = (String)intent.getExtras().get("iData");
        //sendCashbackInfoToClient(iData);
        GetValueInterface getValueInterface = new MainActivity();
        getValueInterface.getValueFrom(iData);


    }

    private void sendCashbackInfoToClient(String msg){

       Intent intent = new Intent();
        intent.setAction("com.MyReceiver");
        intent.putExtra("iData",msg);
        sendBroadcast(intent);

    }
}
