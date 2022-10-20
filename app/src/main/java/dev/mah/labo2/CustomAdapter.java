package dev.mah.labo2;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter<Categorie> {
    private final Activity context;
    private final ArrayList<Categorie> listCategories ;

    public CustomAdapter(@NonNull Activity context, ArrayList<Categorie> listCategories) {
        super(context, R.layout.grid_item, listCategories);
        this.context=context;
        this.listCategories=listCategories;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.grid_item, null,true);
        Categorie categorie = listCategories.get(position);
        TextView titleText = rowView.findViewById(R.id.item_name);
        ImageView imageView = rowView.findViewById(R.id.grid_image);

        int imageResource = context.getResources().getIdentifier(categorie.getThumbnail(), "drawable", context.getPackageName());
        imageView.setImageResource(imageResource);

        titleText.setText(listCategories.get(position).getTitle());

        return rowView;
    }
}


