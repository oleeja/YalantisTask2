package com.kitsyambochka.yalantistask2.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kitsyambochka.yalantistask2.fragments.FragmentForListView;
import com.kitsyambochka.yalantistask2.fragments.FragmentForRecyclerView;
import com.kitsyambochka.yalantistask2.R;
import com.kitsyambochka.yalantistask2.interfaces.ScrollListener;
import com.kitsyambochka.yalantistask2.adapters.PagerAdapterForMain;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, ScrollListener {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.fab) FloatingActionButton mFab;
    @Bind(R.id.drawer_layout) DrawerLayout mDrawer;

    public static final int ITEM_COUNTS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.all_appeals);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_menu);
        toggle.setToolbarNavigationClickListener(this);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initViewPagerAndTabs();
    }

    private void initViewPagerAndTabs() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        PagerAdapterForMain pagerAdapter = new PagerAdapterForMain(getSupportFragmentManager());
        pagerAdapter.addFragment(FragmentForRecyclerView.createInstance(ITEM_COUNTS),
                getString(R.string.tab_1));
        pagerAdapter.addFragment(FragmentForRecyclerView.createInstance(ITEM_COUNTS),
                getString(R.string.tab_2));
        pagerAdapter.addFragment(FragmentForListView.createInstance(ITEM_COUNTS),
                getString(R.string.tab_3));
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.all) {

        } else if (id == R.id.map) {

        }

        mDrawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onClick(View v) {
        mDrawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void onScrollUp(boolean scrollUp) {
        if (scrollUp) {
            mFab.hide();
        } else {
            mFab.show();
        }
    }
}
