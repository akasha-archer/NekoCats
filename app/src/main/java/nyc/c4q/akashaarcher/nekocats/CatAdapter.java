package nyc.c4q.akashaarcher.nekocats;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nyc.c4q.akashaarcher.nekocats.model.Cat;


public class CatAdapter extends RecyclerView.Adapter {

    private Context context;

    private List<Cat> cats = Arrays.asList(
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


    public CatAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CatViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CatViewHolder viewHolder = (CatViewHolder) holder;
        Cat newCat = cats.get(position);
        viewHolder.bind(newCat);
    }


    @Override
    public int getItemCount() {
        return cats.size();
    }
}
