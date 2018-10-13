package com.c13.javahunt.javahunt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

// Custom adapter for Store List View

public class StoreAdapter extends BaseAdapter {
    private String[] names;
    private String[] details;

    private LayoutInflater mInflater;

    public StoreAdapter(Context c, String[] n, String[] i) {
        // constructor
        names = n;
        details = i;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.storeNameTextView);
        TextView detailTextView = (TextView) v.findViewById(R.id.infoTextView);

        String name = names[position];
        String info = details[position];

        nameTextView.setText(name);
        detailTextView.setText(info);

        return v;
    }
}
