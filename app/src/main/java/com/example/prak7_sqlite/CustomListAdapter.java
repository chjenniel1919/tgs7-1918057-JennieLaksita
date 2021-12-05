package com.example.prak7_sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Dokter> movieItems;

    public CustomListAdapter(Activity activity, List<Dokter> movieItems) {
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
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView id_dokter = (TextView) convertView.findViewById(R.id.id_dokter);
        TextView spesialis = (TextView) convertView.findViewById(R.id.text_spesialis);
        Dokter m = movieItems.get(position);
        nama.setText("Nama : "+ m.get_nama());
        id_dokter.setText("ID Dokter : "+ m.get_id_dokter());
        spesialis.setText("Spesialis : "+ m.get_spesialis());
        return convertView;
    }
}

