package nyc.c4q.akashaarcher.nekocats;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nyc.c4q.akashaarcher.nekocats.controller.MyAlarmReceiver;
import nyc.c4q.akashaarcher.nekocats.controller.MyNotificationService;
import nyc.c4q.akashaarcher.nekocats.database.CatDatabaseHelper;
import nyc.c4q.akashaarcher.nekocats.model.Cat;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class MainActivity extends AppCompatActivity {

    int NOTIFICATION_ID = 555;

    SQLiteDatabase db;
    List<Integer> catPics = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup database
        CatDatabaseHelper dbHelper = new CatDatabaseHelper(this);
        db = dbHelper.getWritableDatabase();
        Toast.makeText(getApplicationContext(), "Database acquired", Toast.LENGTH_SHORT).show();


        //adding cat images to list
        catPics.add(R.drawable.cat1);
        catPics.add(R.drawable.cat2);
        catPics.add(R.drawable.cat3);
        catPics.add(R.drawable.cat4);
        catPics.add(R.drawable.cat5);
        catPics.add(R.drawable.cat6);
        catPics.add(R.drawable.cat7);
        catPics.add(R.drawable.cat8);
        catPics.add(R.drawable.cat9);
        catPics.add(R.drawable.cat10);
        catPics.add(R.drawable.cat11);
        catPics.add(R.drawable.cat12);
        catPics.add(R.drawable.cat13);
        catPics.add(R.drawable.cat14);
        catPics.add(R.drawable.cat15);
        catPics.add(R.drawable.cat16);
        catPics.add(R.drawable.cat17);
        catPics.add(R.drawable.cat18);
        catPics.add(R.drawable.cat19);
        catPics.add(R.drawable.cat20);
        catPics.add(R.drawable.cat21);
        catPics.add(R.drawable.cat22);
        catPics.add(R.drawable.cat23);
        catPics.add(R.drawable.cat24);
        catPics.add(R.drawable.cat25);


        //adding Cats to the database
        for (int i = 1; i < 26; i++) {
            Cat newCat = new Cat("Cat #" + i, catPics.get(i - 1));
            long id = cupboard().withDatabase(db).put(newCat);
        }

        launchTestService();
    }


    public void launchTestService() {
        Intent mainIntent = new Intent(this, MyNotificationService.class);
        startService(mainIntent);
        // Toast.makeText(getApplicationContext(),"notification!",Toast.LENGTH_SHORT).show();
    }

    public void scheduleAlarm() {
        // Construct an intent that will execute the AlarmReceiver
        Intent intent = new Intent(getApplicationContext(), MyAlarmReceiver.class);

        // Create a PendingIntent to be triggered when the alarm goes off
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, MyAlarmReceiver.REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        long firstMillis = System.currentTimeMillis(); // alarm is set right away

        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
        // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, AlarmManager.INTERVAL_FIFTEEN_MINUTES, pendingIntent);
    }
}
