package com.kitsyambochka.yalantistask2.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kitsyambochka.yalantistask2.R;
import com.kitsyambochka.yalantistask2.adapters.PagerAdapterForMain;
import com.kitsyambochka.yalantistask2.fragments.FragmentForListView;
import com.kitsyambochka.yalantistask2.fragments.FragmentForRecyclerView;
import com.kitsyambochka.yalantistask2.interfaces.ScrollListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, ScrollListener {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.fab) FloatingActionButton mFab;
    @Bind(R.id.drawer_layout) DrawerLayout mDrawer;
    @Bind(R.id.nav_view) NavigationView mNavigationView;
    @Bind(R.id.viewPager) ViewPager mViewPager;
    @Bind(R.id.tabLayout) TabLayout mTabLayout;

    public static final int ITEM_COUNTS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(R.string.all_appeals);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: do some logic for FAB
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_menu);
        toggle.setToolbarNavigationClickListener(this);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);

        initViewPagerAndTabs();
    }

    private void initViewPagerAndTabs() {
        PagerAdapterForMain pagerAdapter = new PagerAdapterForMain(getSupportFragmentManager());
        pagerAdapter.addFragment(FragmentForRecyclerView.createInstance(ITEM_COUNTS),
                getString(R.string.tab_1));
        pagerAdapter.addFragment(FragmentForRecyclerView.createInstance(ITEM_COUNTS),
                getString(R.string.tab_2));
        pagerAdapter.addFragment(FragmentForListView.createInstance(ITEM_COUNTS),
                getString(R.string.tab_3));
        mViewPager.setAdapter(pagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
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
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.all:
                //TODO: do some logic for item in navigation drawer
                break;
            case R.id.map:
                //TODO: do some logic for item in navigation drawer
                break;
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
