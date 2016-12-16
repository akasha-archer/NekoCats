package nyc.c4q.akashaarcher.nekocats;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.akashaarcher.nekocats.model.Cat;

/**
 * Created by Akasha on 12/15/16.
 */

public class CatAdapter extends RecyclerView.Adapter {

    private List<Cat> cats;

    public CatAdapter() {
        this.cats = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
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
