package com.collegeapp.onthespot.collegeapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vikas Kumar on 07-10-2015.
 */
public class NavigationDrawerFragment extends Fragment {


    private RecyclerView recyclerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private VikasAdapter adapter;


    public NavigationDrawerFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerlist);
        adapter = new VikasAdapter(getActivity(), getData());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return layout;
    }


    public List<Information> getData() {
        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.bullet, R.drawable.bullet, R.drawable.bullet, R.drawable.bullet};
        String[] titles = {"vikas", "sidd", "rahul", "rohan"};


        for (int i = 0; i < titles.length && i < icons.length; i++) {

            Information current = new Information();
            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);


        }

        return data;

    }


    public void setUp(DrawerLayout drawerlayout, final Toolbar toolbar) {
        mDrawerLayout = drawerlayout;

        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerlayout, toolbar, R.string.drawer_open, R.string.drawer_close) {




            @Override
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);

                //getActivity().invalidateOptionsMenu();


            }

            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);

                //getActivity().invalidateOptionsMenu();

            }


            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                if (slideOffset < .6) {
                    toolbar.setAlpha(1 - slideOffset);
                }
            }
        };

        //mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);



    }

}
