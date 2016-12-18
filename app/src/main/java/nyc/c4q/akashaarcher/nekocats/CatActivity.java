package nyc.c4q.akashaarcher.nekocats;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import nl.qbusict.cupboard.QueryResultIterable;
import nyc.c4q.akashaarcher.nekocats.controller.MyNotificationService;
import nyc.c4q.akashaarcher.nekocats.database.CatDatabaseHelper;
import nyc.c4q.akashaarcher.nekocats.model.Cat;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by akashaarcher on 12/13/16.
 */
public class CatActivity extends Activity {

    SQLiteDatabase db;

    private List<Cat> catList;
    private RecyclerView rvCats;
    private CatAdapter adapter;
    private static final String TAG = CatActivity.class.getSimpleName();

    public List<Cat> cats = Arrays.asList(
            new Cat("Cat #1", R.drawable.cat1),
            new Cat("Cat #2", R.drawable.cat2),
            new Cat("Cat #3", R.drawable.cat3),
            new Cat("Cat #4", R.drawable.cat4),
            new Cat("Cat #5", R.drawable.cat5),
            new Cat("Cat #6", R.drawable.cat6),
            new Cat("Cat #7", R.drawable.cat7),
            new Cat("Cat #8", R.drawable.cat8),
            new Cat("Cat #9", R.drawable.cat9),
            new Cat("Cat #10", R.drawable.cat10),
            new Cat("Cat #11", R.drawable.cat11),
            new Cat("Cat #12", R.drawable.cat12),
            new Cat("Cat #13", R.drawable.cat13),
            new Cat("Cat #14", R.drawable.cat14),
            new Cat("Cat #15", R.drawable.cat15),
            new Cat("Cat #16", R.drawable.cat16),
            new Cat("Cat #17", R.drawable.cat17),
            new Cat("Cat #18", R.drawable.cat18),
            new Cat("Cat #19", R.drawable.cat19),
            new Cat("Cat #20", R.drawable.cat20),
            new Cat("Cat #21", R.drawable.cat21),
            new Cat("Cat #22", R.drawable.cat22),
            new Cat("Cat #23", R.drawable.cat23),
            new Cat("Cat #24", R.drawable.cat24),
            new Cat("Cat #25", R.drawable.cat25)
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);

        // get an instance of the DatabaseHelper
        CatDatabaseHelper dbHelper = CatDatabaseHelper.getInstance(this);
        db = dbHelper.getWritableDatabase();

        int catPick = pickNewCat(cats);
        Cat newCat = cats.get(catPick);
        Toast.makeText(getApplicationContext(), "You have a new cat! Cat #" + catPick, Toast.LENGTH_SHORT).show();
        addCat(newCat);

        long firstId = newCat.getId();
        Toast.makeText(getApplicationContext(), "cat Id " + firstId, Toast.LENGTH_SHORT).show();

        catList = new ArrayList<Cat>();
        catList = getAllCats();

        rvCats = (RecyclerView) findViewById(R.id.rv_cats);
        rvCats.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new CatAdapter(this, catList);
        rvCats.setAdapter(adapter);


    }

    private void addCat(Cat cat) {
        cupboard().withDatabase(db).put(cat);
    }

    private List<Cat> getAllCats() {
        List<Cat> allCats = new ArrayList<>();

        try {
            // Iterate cats
            QueryResultIterable<Cat> itr = cupboard().withDatabase(db).query(Cat.class).query();
            for (Cat cat : itr) {
                allCats.add(cat);
            }
            itr.close();
        } catch (Exception e) {
            Log.e(TAG, "selectAllCats: ", e);
        }

        return allCats;
    }


    public int pickNewCat(List<Cat> catsArrayList) {
        Random rand = new Random();
        int min = 1;
        int max = catsArrayList.size();
        int catNumber = rand.nextInt((max - min) + 1) + min;
        Cat catPick = catsArrayList.get(catNumber);
        // catList.remove(catNumber);
        return catNumber;
    }


//    public Cat pickNewCat(List<Cat> catsArrayList) {
//        Random rand = new Random();
//        int min = 1;
//        int max = catsArrayList.size();
//        int catNumber = rand.nextInt((max-min) + 1) + min;
//        Cat catPick = catsArrayList.get(catNumber);
//        // catList.remove(catNumber);
//        return catPick;
//    }

    private String changeCatName(Cat cat) {
        //To update an item, simply retrieve it from the database,

        // update it's accessible fields,

        // and use put() to get it back into the database
        cupboard().withDatabase(db).put(cat);
        return null;
    }
}
