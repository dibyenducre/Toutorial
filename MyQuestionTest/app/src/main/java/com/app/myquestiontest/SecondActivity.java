package com.app.myquestiontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    ModelData data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

       // ModelData data = (ModelData) getIntent().getSerializableExtra("iData");
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(data.getName());


    }
}
