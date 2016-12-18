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
    private List<Cat> cats;


    public CatAdapter(Context context, List<Cat> cats) {
        this.context = context;
        this.cats = new ArrayList<>();
        notifyDataSetChanged();
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
