package medifact.upin.medifact;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public  class Pedometer extends Fragment {

    View parentHolder;
    ImageButton Shoes;
    Activity UpdatesActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        parentHolder = inflater.inflate(R.layout.updates, container, false);
        Shoes = (ImageButton)parentHolder.findViewById(R.id.shoes);

        UpdatesActivity = getActivity();
        Shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Pedo_New.class);
                startActivity(intent);
            }
        });
        return parentHolder;
    }


}