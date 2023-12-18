package com.example.newyearproger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    ImageView imageView2;
    //private ActivitymainBinding binding;
    private final int[] images = {R.drawable.img_2,R.drawable.img_3,R.drawable.scale_1200};
    private int carNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView2 = findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void nextCar(){
        carNum = ++carNum%3;
        imageView2.setImageDrawable(AppCompatResources.getDrawable((getApplicationContext(), images[carNum])));
        imageView2
    }
}