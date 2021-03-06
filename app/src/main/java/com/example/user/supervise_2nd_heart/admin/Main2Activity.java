package com.example.user.supervise_2nd_heart.admin;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.user.supervise_2nd_heart.R;
import com.tsengvn.typekit.TypekitContextWrapper;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        LinearLayout back2;
        ImageView com1,myPage1,phone1,industry1;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity_main);
        /////////////////////////////메인 엑티비트에 나와있는 아이콘 클릭 이벤트 처리담당
        back2 = (LinearLayout)findViewById(R.id.back2);
        com1 = (ImageView)findViewById(R.id.com1);
        myPage1 = (ImageView)findViewById(R.id.myPage1);
        phone1 = (ImageView)findViewById(R.id.phone1);
        industry1 =(ImageView)findViewById(R.id.industry1);

        com1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main,new admin_com()).addToBackStack(null).commit();
                back2.setVisibility(View.INVISIBLE);
            }
        });
        myPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main,new Admin_Mypage_Main()).addToBackStack(null).commit();
                back2.setVisibility(View.INVISIBLE);
            }
        });
        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main,new admin_register()).addToBackStack(null).commit();
                back2.setVisibility(View.INVISIBLE);
            }
        });
        industry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main,new admin_customer()).addToBackStack(null).commit();
                back2.setVisibility(View.INVISIBLE);
            }
        });

        ////////////////////////////
        ActionBar actionBar = getActionBar();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ////////////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
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

        FragmentManager manager = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.com) {
            manager.beginTransaction().replace(R.id.content_main,new admin_com()).addToBackStack(null).commit();
            back2.setVisibility(View.INVISIBLE);
        } else if (id == R.id.man) {
            manager.beginTransaction().replace(R.id.content_main,new Admin_Mypage_Main()).addToBackStack(null).commit();
            back2.setVisibility(View.INVISIBLE);
        } else if (id == R.id.phone) {
            manager.beginTransaction().replace(R.id.content_main,new admin_register()).addToBackStack(null).commit();
            back2.setVisibility(View.INVISIBLE);
        } else if (id == R.id.industry) {
            manager.beginTransaction().replace(R.id.content_main,new admin_customer()).addToBackStack(null).commit();
            back2.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

