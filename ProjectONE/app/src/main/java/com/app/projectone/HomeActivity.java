package com.app.projectone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    Button btn_list_of_fruit;
    ImageView img_user_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        img_user_image = (ImageView) findViewById(R.id.img_user_image);
        btn_list_of_fruit = (Button) findViewById(R.id.btn_list_of_fruit);

        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            Bitmap imageData = (Bitmap) intent.getExtras().get("iImage");
            img_user_image.setImageBitmap(imageData);
        }

        btn_list_of_fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iObject = new Intent(HomeActivity.this, FruitListActivity.class);
                startActivity(iObject);
            }
        });

    }
}
