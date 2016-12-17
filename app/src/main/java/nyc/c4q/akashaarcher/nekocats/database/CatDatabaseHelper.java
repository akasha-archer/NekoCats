package nyc.c4q.akashaarcher.nekocats.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nyc.c4q.akashaarcher.nekocats.model.Cat;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by Akasha on 12/15/16.
 */

public class CatDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "cat.db";
    private static final int DATABASE_VERSION = 1;


    // make your database instance a singleton instance across the entire application's lifecycle.
    private static CatDatabaseHelper instance;


    public static synchronized CatDatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (instance == null) {
            instance = new CatDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    public CatDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        // register our models
        cupboard().register(Cat.class);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // this will ensure that all tables are created
        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this will upgrade tables, adding columns and new tables.
        // Note that existing columns will not be converted
        cupboard().withDatabase(db).upgradeTables();
    }

}
