package medifact.upin.medifact;

import android.app.Activity;
import android.app.Fragment;
import android.app.Notification;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.graphics.Bitmap;

public class Updates extends Fragment {
    Activity UpdatesActivity;
    View parentHolder;
    Button tips;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        UpdatesActivity = getActivity();
        parentHolder = inflater.inflate(R.layout.updates, container, false);
        tips = parentHolder.findViewById(R.id.tips);
        return parentHolder;
    }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            //you can set the title for your toolbar here for different fragments different titles
            getActivity().setTitle("Menu 1");
            tips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    NotificationCompat.Builder notif=new NotificationCompat.Builder(getActivity());
                            notif.setSmallIcon(android.R.drawable.stat_notify_more);
                       notif.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)); //how does this work
                        notif.setContentTitle("Hello, world!");
                        notif.setContentText("I am a notification");
                    notif.setDefaults(Notification.DEFAULT_ALL);
                    NotificationManagerCompat notif2=NotificationManagerCompat.from(getActivity());
                    notif2.notify(1, notif.build());

                }
            });
        }

    }



