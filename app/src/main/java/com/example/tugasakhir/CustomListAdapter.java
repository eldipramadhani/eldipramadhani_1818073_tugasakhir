package com.example.tugasakhir;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tugasakhir.Anime;
import com.example.tugasakhir.R;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Anime> movieItems;

    public CustomListAdapter(Activity activity, List<Anime> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView judul = (TextView) convertView.findViewById(R.id.text_judul);
        TextView durasi = (TextView) convertView.findViewById(R.id.text_durasi);
        TextView rating = (TextView) convertView.findViewById(R.id.text_rating);
        TextView rated = (TextView) convertView.findViewById(R.id.text_rated);
        Anime m = movieItems.get(position);
        judul.setText("Judul : "+ m.get_judul());
        durasi.setText("Durasi : "+ m.get_durasi());
        rating.setText("Rating : "+ m.get_rating());
        rated.setText("Rated : "+ m.get_rated());
        return convertView;
    }
}