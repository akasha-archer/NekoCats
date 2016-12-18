package nyc.c4q.akashaarcher.nekocats.controller;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import nyc.c4q.akashaarcher.nekocats.CatActivity;
import nyc.c4q.akashaarcher.nekocats.MainActivity;
import nyc.c4q.akashaarcher.nekocats.R;
import nyc.c4q.akashaarcher.nekocats.model.Cat;

/**
 * Created by akashaarcher on 12/13/16.
 */

public class MyNotificationService extends IntentService {

    Random random = new Random();
    private static final String SERVICE_NAME = "notification-service";
    int NOTIFICATION_ID = 555; // Setting a notification ID allows you to update the notification later on.

    MainActivity activityMain = new MainActivity();


    public MyNotificationService() {
        super(SERVICE_NAME);
    }

    @Override
    public void onCreate() {
        super.onCreate(); // if you override onCreate(), make sure to call super().
        // If a Context object is needed, call getApplicationContext() here.
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        intent = new Intent(this, CatActivity.class);
        int requestID = (int) System.currentTimeMillis(); // Unique requestID to differentiate between various notification with same notification ID
        int flags = PendingIntent.FLAG_CANCEL_CURRENT; // Cancel old intent and create new one
        PendingIntent pendingIntent = PendingIntent.getActivity(this, requestID, intent, flags);

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.cat_notification)
                .setContentTitle("Neko Cats")
                .setContentText("A new cat is here")
                .setSubText("Tap to View")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) // Hides the notification after its been selected
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }


}
