package nyc.c4q.akashaarcher.nekocats;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import nyc.c4q.akashaarcher.nekocats.model.Cat;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by akashaarcher on 12/13/16.
 */
public class CatActivity extends Activity {

    SQLiteDatabase db;
    RecyclerView rvCats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);

    }

    private String changeCatName(Cat cat) {
        //To update an item, simply retrieve it from the database,


        // update it's accessible fields,

        // and use put() to get it back into the database
        cupboard().withDatabase(db).put(cat);
        return null;
    }
}
