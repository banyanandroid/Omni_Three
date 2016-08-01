package com.banyan.omni_three;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class Activity_Capsierate extends FragmentActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static final int ITEMS = 14;
    //TextView one, two, three, four, five, six, seven, eight, nine;
    MyAdapter mAdapter;
    ViewPager mPager;

    //MediaPlayer player;
    //AssetFileDescriptor afd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capsierate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        mAdapter = new MyAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);

        mPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


        mPager.setAdapter(mAdapter);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    public static class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        @Override
        public int getCount() {
            return ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show image
                    return Fragment_cap1.init(position);
                case 1: // Fragment # 1 - This will show image
                    return Fragment_cap2.init(position);
                case 2: // Fragment # 2 - This will show image
                    return Fragment_Video1.init(position);
                case 3: // Fragment # 0 - This will show image
                    return Fragment_cap3.init(position);
                case 4: // Fragment # 1 - This will show image
                    return Fragment_cap3_1.init(position);
                case 5: // Fragment # 2 - This will show image
                    return Fragment_cap4.init(position);
                case 6: // Fragment # 0 - This will show image
                    return Fragment_cap5.init(position);
                case 7: // Fragment # 1 - This will show image
                    return Fragment_cap6.init(position);
                case 8: // Fragment # 2 - This will show image
                    return Fragment_cap7.init(position);
                case 9: // Fragment # 0 - This will show image
                    return Fragment_cap8.init(position);
                /*case 10: // Fragment # 1 - This will show image
                    return Fragment_12.init(position);
                case 11: // Fragment # 2 - This will show image
                    return Fragment_13.init(position);*/

                default:// Fragment # 2-9 - Will show list
                    return null;
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Fragment_cap1.init(0);
        }
    }


    public void onPause() {
        super.onPause();
        //player.stop();
    }

    //To resume this player we have to call following method.
    public void onResume() {
        super.onResume();
        //sng();
        //player.start();

    }

    // activity is going to stop we have to call this to release the media player
    protected void onStop() {
        super.onStop();
        //player.stop();
        //player = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cardio) {
            // Handle the CurONC action
            Intent in = new Intent(this, Activity_Cardio.class);
            startActivity(in);
        } else if (id == R.id.nav_fertility) {
            //Handle the Ultr Action
            Intent in = new Intent(this, Activity_Fertility.class);
            startActivity(in);

        } else if (id == R.id.nav_capsierate) {
            //Handle the Ultr Action
            Intent inm = new Intent(this, Activity_Capsierate.class);
            startActivity(inm);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
