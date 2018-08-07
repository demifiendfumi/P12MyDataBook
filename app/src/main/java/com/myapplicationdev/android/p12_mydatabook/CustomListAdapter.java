package com.myapplicationdev.android.p12_mydatabook;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private Context context;
    private String [] itemName;
    private int [] imgId;

    public CustomListAdapter(Context context, int resource, String[] itemName, int[] imgId) {
        super(context, resource, itemName);
        this.itemName = itemName;
        this.imgId = imgId;
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.navigation_list, parent,false);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.Itemname);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText(itemName[position]);
        imageView.setImageResource(imgId[position]);
        return rowView;
    }
}
