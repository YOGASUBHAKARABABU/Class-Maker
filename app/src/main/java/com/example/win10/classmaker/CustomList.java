package com.example.win10.classmaker;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by WIN 10 on 12-07-2017.
 */

public class CustomList extends ArrayAdapter<String>{

    private String[] names;
    private Integer[] k;
    private Activity context;


    public CustomList(Activity context, String[] names,Integer[] k) {
        super(context, R.layout.listview_layout, names);
        this.context = context;
        this.names = names;
        this.k = k;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listview_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.txt);
        textViewName.setText(names[position]);
        ImageView image = (ImageView) listViewItem.findViewById(R.id.flag);
        image.setImageResource(k[position]);

        return  listViewItem;
    }
}
