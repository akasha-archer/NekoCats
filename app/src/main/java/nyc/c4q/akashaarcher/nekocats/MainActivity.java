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

        // get an instance of the DatabaseHelper
        CatDatabaseHelper dbHelper = CatDatabaseHelper.getInstance(this);
        db = dbHelper.getWritableDatabase();

        launchTestService();
    }

    public Cat pickNewCat(List<Cat> catList) {
        Random rand = new Random();
        int min = 1;
        int catNumber = rand.nextInt((catList.size()-min) + 1) + min;
        Cat newCat = catList.get(catNumber);
        catList.remove(catNumber);
        return newCat;
    }

    private void addCat(Cat cat) {
        cupboard().withDatabase(db).put(cat);
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
