package medifact.upin.medifact;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public  class Counter extends AppCompatActivity implements SensorEventListener{

    TextView tv_steps;
    SensorManager sensorManager;
    Button button;

    boolean running=false;
    double mLastX ;
    double mLastY;
    double mLastZ;
    float steps=0;


    private final float NOISE = (float) 2.0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date();
        tv_steps=(TextView) findViewById(R.id.tv_steps);
        button=(Button)findViewById(R.id.button);




    }

    public void date()
    {
        TextView time = (TextView) findViewById(R.id.Date);

        String currentDateString = DateFormat.getDateInstance().format(new Date());
        time.setText(currentDateString);
    }

    public void calories()
    {
        final double calories;
        double K_cal =0.05;
        calories=steps*K_cal;

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(Counter.this,Double.toString(calories), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {


        // event object contains values of acceleration, read those
        double x = sensorEvent.values[0];
        double y = sensorEvent.values[1];
        double z = sensorEvent.values[2];


        final double alpha = 0.8; // constant for our filter below


        double[] gravity = {0, 0, 0};


        // Isolate the force of gravity with the low-pass filter.
        gravity[0] = alpha * gravity[0] + (1 - alpha) * sensorEvent.values[0];
        gravity[1] = alpha * gravity[1] + (1 - alpha) * sensorEvent.values[1];
        gravity[2] = alpha * gravity[2] + (1 - alpha) * sensorEvent.values[2];

        // Remove the gravity contribution with the high-pass filter.
        x = sensorEvent.values[0] - gravity[0];
        y = sensorEvent.values[1] - gravity[1];
        z = sensorEvent.values[2] - gravity[2];


        if (!running)
        {
            // sensor is used for the first time, initialize the last read values
            mLastX = x;
            mLastY = y;
            mLastZ = z;
            running = true;
        }

        else {
            // sensor is already initialized, and we have previously read values.
            // take difference of past and current values and decide which
            // axis acceleration was detected by comparing values

            double deltaX = Math.abs(mLastX - x);
            double deltaY = Math.abs(mLastY - y);
            double deltaZ = Math.abs(mLastZ - z);
            if (deltaX < NOISE)
                deltaX = (float) 0.0;
            if (deltaY < NOISE)
                deltaY = (float) 0.0;
            if (deltaZ < NOISE)
                deltaZ = (float) 0.0;
            mLastX = x;
            mLastY = y;
            mLastZ = z;

            tv_steps.setText(Float.toString(steps));

            if (deltaX > deltaY)
            {
                // Horizontal  X shake  do something here if you like

            }

            else if (deltaY > deltaX)
            {
                // Vertical Y shake do something here if you like

            }

            else if ((deltaZ > deltaX) && (deltaZ > deltaY))

            {
                // Z shake
                steps++;
                if (steps > 0) {
                    tv_steps.setText(Float.toString(steps));
                }
                else
                {
                    tv_steps.setText("NO step TAken");
                }



            }
        }

        calories();

    }






    @Override
    public void onAccuracyChanged(Sensor sensor, int i)
    {
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        tv_steps.setText("OnAccuracy");

    }


    @Override
    protected void onResume ()

    {
        super.onResume();
        running = true;
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor countSensor1 = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, countSensor1, SensorManager.SENSOR_DELAY_FASTEST);


        Toast.makeText(this,"Resume  ", Toast.LENGTH_LONG);
        tv_steps.setText("resume");

    }

    @Override
    protected void onPause ()
    {
        super.onPause();
        running = false;
        tv_steps.setText("Pause");
        sensorManager.unregisterListener(this);


    }


}
