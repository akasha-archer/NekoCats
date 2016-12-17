package nyc.c4q.akashaarcher.nekocats;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.akashaarcher.nekocats.model.Cat;

/**
 * Created by Akasha on 12/15/16.
 */

public class CatViewHolder extends RecyclerView.ViewHolder {

    private final View view;
    private ImageView catPic;
    private TextView catNum;


    public CatViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        view = itemView;
        catPic = (ImageView) view.findViewById(R.id.cat_pic);
        catNum = (TextView) view.findViewById(R.id.cat_name);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.cat_layout, parent, false);
    }

    public void bind(Cat cat) {
        catNum.setText(cat.getCatNumber());
        Integer resource = cat.getCatImage();
        if (resource != null) {
            catPic.setImageResource(resource);
        }
    }
}
