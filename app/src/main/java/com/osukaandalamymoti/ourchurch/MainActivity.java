package com.osukaandalamymoti.ourchurch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.osukaandalamymoti.ourchurch.Fragments.BibleFragment;
import com.osukaandalamymoti.ourchurch.Fragments.EventsFragment;
import com.osukaandalamymoti.ourchurch.Fragments.HomeFragment;
import com.osukaandalamymoti.ourchurch.Fragments.MoreFragment;
import com.osukaandalamymoti.ourchurch.Fragments.MusicFragment;
import com.osukaandalamymoti.ourchurch.Utils.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {
    SlidingTabLayout tabs;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = preferences.getBoolean("previouslyStarted", false);
        if(!previouslyStarted){
            SharedPreferences.Editor edit = preferences.edit();
            edit.putBoolean("previouslyStarted", true).apply();
            Intent intent = new Intent(this, Splash.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);   
        }


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainPagerAdapter);
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        tabs.setSelectedIndicatorColors(getResources().getColor(R.color.colorPrimary));
        tabs.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private static class MainPagerAdapter extends FragmentPagerAdapter {

        public int getMyNotsCount() {
            return myNotsCount;
        }

        public void setMyNotsCount(int myNotsCount) {
            this.myNotsCount = myNotsCount;
        }

        private int myNotsCount;

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new EventsFragment();
                case 2:
                    return new BibleFragment();
                case 3:
                    return new MusicFragment();

            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Home";
                case 1:
                    return "Events";
                case 2:
                    return "Bible";
                case 3:
                    return "MUsic";

            }
            return super.getPageTitle(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

    }

}
