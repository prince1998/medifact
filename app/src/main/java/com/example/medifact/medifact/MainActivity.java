package com.example.medifact.medifact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Handler;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run(){
                final Intent mainIntent = new Intent(MainActivity.this, com.example.medmedifact.Main2Activity.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }
        }, 5000);


    }

}

//hello