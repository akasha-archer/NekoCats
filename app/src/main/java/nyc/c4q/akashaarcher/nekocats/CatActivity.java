package nyc.c4q.akashaarcher.nekocats;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

/**
 * Created by akashaarcher on 12/13/16.
 */
public class CatActivity extends Activity {

    RecyclerView rvCats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);

    }
}
