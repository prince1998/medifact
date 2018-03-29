package com.upin.medifact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class pedometer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);
            date();
            TextView StepCounter=(TextView) findViewById(R.id.Step_Count);
            StepCounter.setText("Hello");


        }

        public void date()
        {
            TextView time = (TextView) findViewById(R.id.Date);

            String currentDateString = DateFormat.getDateInstance().format(new Date());
            time.setText(currentDateString);
        }


}

