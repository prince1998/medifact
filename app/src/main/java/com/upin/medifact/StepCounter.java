package com.upin.medifact;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ilesha on 29/03/18.
 */

public abstract class StepCounter extends pedometer implements SensorEventListener {
    SensorManager sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    Sensor stepSensor = sManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

    private long timestamp;

    private TextView StepCounter = (TextView) findViewById(R.id.Step_Count);


    private TextView textViewStepDetector = (TextView) findViewById(R.id.Detect);

    private Thread detectorTimeStampUpdaterThread;

    private Handler handler;

    private boolean isRunning = true;


    Button bn = (Button) findViewById(R.id.button);
    float steps = 0;
    pedometer sr = new pedometer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sr.date();
        //TextView StepCounter= (TextView) findViewById(R.id.textView);
        steps = registerForSensorEvents();
        StepCounter.setText("Hello");
        int k = (int) steps;
        //onAccuracyChanged( Sensor.TYPE_STEP_COUNTER,k);

        //setupDetectorTimestampUpdaterThread();
    }


    public float registerForSensorEvents() {
        SensorManager sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Step Counter
        sManager.registerListener(new SensorEventListener() {

                                      @Override
                                      public void onSensorChanged(SensorEvent event) {
                                          steps = event.values[0];
                                          StepCounter.setText(Float.toString(steps));

                                      }

                                      @Override
                                      public void onAccuracyChanged(final Sensor sensor, final int accuracy) {
                                          //No op

                                      }
                                  },
                sManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR),
                SensorManager.SENSOR_DELAY_FASTEST);
        //getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)SensorManager.SENSOR_DELAY_UI);
        return steps;


    }
}
