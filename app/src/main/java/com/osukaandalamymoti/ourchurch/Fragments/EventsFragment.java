package com.osukaandalamymoti.ourchurch.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.osukaandalamymoti.ourchurch.Adapters.EventsAdapter;
import com.osukaandalamymoti.ourchurch.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {
    GridView event_grid;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_events, container, false);

        event_grid = (GridView) v.findViewById(R.id.event_grid);
        event_grid.setAdapter(new EventsAdapter(getActivity()));
        return v;
    }

}
