package com.app.myquestiontest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements GetValueInterface, TwoFragment.TwoFragmentListner {


    Intent serviceIntent;

    MyServiceBind mBoundService;
    boolean mServiceBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(">>","CREATE"+savedInstanceState);

        serviceIntent =  new Intent(MainActivity.this, MyServiceBind.class);


       /* ModelData data = new ModelData();
        data.setName("HEllo");

        SecondActivity secondActivity = new SecondActivity(data);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
       // intent.putExtra("iData", (Serializable) data);
        startActivity(intent);*/

        Button btn_load1 = (Button)findViewById(R.id.btn_load1);
        btn_load1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* Bundle bundle = new Bundle();
                bundle.putString("iData","Hello");

                OneFragment oneFragment = new OneFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                oneFragment.setArguments(bundle);
                ft.addToBackStack("ONE");
                ft.add(R.id.container, oneFragment);
                ft.commit();*/

               /* Intent cbIntent =  new Intent();
                cbIntent.setClass(MainActivity.this, MyIntentService.class);
                cbIntent.putExtra("iData", "Hello Intent Service");
                startService(cbIntent);*/

              /* startService(serviceIntent);
                bindService(serviceIntent, mServiceConnection, Context.BIND_AUTO_CREATE);

*/

                Log.d(">>","CLICK 1");
                Intent intent = new Intent();
                intent.setAction("com.MyReceiver");
                intent.putExtra("iData","hi Android");
                sendBroadcast(intent);


            }
        });



        Button btn_load2 = (Button)findViewById(R.id.button);
        btn_load2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TwoFragment twoFragment = new TwoFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.addToBackStack("TWO");
                ft.replace(R.id.container, twoFragment);
                ft.commit();

                /*unbindService(mServiceConnection);
                stopService(serviceIntent);*/

            }
        });


    }


    private void sendtoBroadCast(String msg){



    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyServiceBind.MyBinder myBinder = (MyServiceBind.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(">>","START");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(">>","ONRESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(">>","PAUSE");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(">>","STOP");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(">>","DESTROY");

    }

    @Override
    public void getValueFrom(String value) {
        Log.d("ACT >>>GET Value ",value);
    }

    @Override
    public void getResult(String value) {
        Log.d("ACT >>>GET Value------ ",value);
    }

}
