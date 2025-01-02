package com.example.mobil_prog_odev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] ad;
    int[] resim;
    LayoutInflater inflater;

    public CustomAdapter(int[] resim, String[] ad, Context context) {
        this.resim = resim;
        this.ad = ad;
        this.context = context;
    }

    @Override
    public int getCount() {
        return resim.length;
    }

    @Override
    public Object getItem(int position) {
        return resim[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satir = LayoutInflater.from(context).inflate(R.layout.liste, parent, false);
        ImageView img = satir.findViewById(R.id.imageView);
        TextView txt = satir.findViewById(R.id.textView);

        img.setBackgroundResource(resim[position]);
        txt.setText(ad[position]);

        return satir;
    }
}
