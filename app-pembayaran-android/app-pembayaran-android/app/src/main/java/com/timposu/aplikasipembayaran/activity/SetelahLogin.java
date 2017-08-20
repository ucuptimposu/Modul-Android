package com.timposu.aplikasipembayaran.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.timposu.aplikasipembayaran.R;
import com.timposu.aplikasipembayaran.dao.TagihanDao;
import com.timposu.aplikasipembayaran.domain.Tagihan;
import com.timposu.aplikasipembayaran.fragment.DashboardFragment;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SetelahLogin extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "NOTIFIKASI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setelah_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadFragment(new DashboardFragment());
        //deleteAllDataTagihan();
        insertDummyData();
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
        getMenuInflater().inflate(R.menu.setelah_login, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.replace(R.id.fragment_setelah_login, fragment);
        fragmentTransaction.commit();
    }

    public void insertDummyData(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        TagihanDao tagihanDao = new TagihanDao(this);

        Tagihan t1 = new Tagihan();
        t1.setNamaPelanggan("Asmad");
        t1.setNamaProduk("PLN Pascabayar");
        t1.setNomorPelanggan("12345678");
        t1.setNilai(new BigDecimal("100000.00"));

        try {
            t1.setBulanTagihan(dateFormat.parse("2017-07-01"));
            t1.setJatuhTempo(dateFormat.parse("2017-07-20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tagihanDao.insertTagihan(t1);

        Tagihan t2 = new Tagihan();
        t2.setNamaPelanggan("Danu Wirnoyo");
        t2.setNamaProduk("Telkom");
        t2.setNomorPelanggan("1234587988");
        t2.setNilai(new BigDecimal("600000.00"));

        try {
            t2.setBulanTagihan(dateFormat.parse("2017-07-01"));
            t2.setJatuhTempo(dateFormat.parse("2017-07-20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

       tagihanDao.insertTagihan(t2);

        Tagihan t3 = new Tagihan();
        t3.setNamaPelanggan("Ucup Timposu");
        t3.setNamaProduk("PDAM");
        t3.setNomorPelanggan("12345687778");
        t3.setNilai(new BigDecimal("50000.00"));

        try {
            t3.setBulanTagihan(dateFormat.parse("2017-07-01"));
            t3.setJatuhTempo(dateFormat.parse("2017-07-20"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

       tagihanDao.insertTagihan(t3);
    }

    private void deleteAllDataTagihan(){
        new TagihanDao(this).hapusSemuaTagihan();
    }

//    private void getToken() {
//        Log.d(TAG, "");
//    }
}
