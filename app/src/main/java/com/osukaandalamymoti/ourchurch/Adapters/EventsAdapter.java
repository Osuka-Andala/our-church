package com.osukaandalamymoti.ourchurch.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osukaandalamymoti.ourchurch.R;

/**
 * Created by osuka on 7/28/16.
 */
public class EventsAdapter extends BaseAdapter {

    private final Context context;
    private String[] menuItems = {"Service", "Stuff", "Event"};
    private int[] images = {R.mipmap.ic_launcher,R.mipmap.welcomehome,R.mipmap.welcomehome,};
    private String[] descriptions ={"Service", "Stuff", "Event"};

    public EventsAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return menuItems.length;
    }

    @Override
    public Object getItem(int position) {
        return menuItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.event_item, parent, false);
        } else {
            row = convertView;

        }

        TextView eventNameTv = (TextView) row.findViewById(R.id.eventName);
        TextView eventDetailsTv = (TextView) row.findViewById(R.id.eventDetails);
        ImageView eventImage = (ImageView) row.findViewById(R.id.eventImage);
        eventNameTv.setText(menuItems[position]);
        eventImage.setImageResource(images[position]);
        eventDetailsTv.setText(descriptions[position]);



        return row;
    }
}
