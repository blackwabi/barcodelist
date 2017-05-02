package com.blackwabi.barcodelist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.blackwabi.barcodelist.di.ActivityComponent;
import com.blackwabi.barcodelist.di.ActivityComponentContainer;
import com.blackwabi.barcodelist.di.ActivityModule;

public class BarcodeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ActivityComponentContainer {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private ActivityComponent mActivityComponent;
    private PictureListener mPictureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We need to create an instance of the activity component and its object graph
        createAndInjectActivityComponent();

        setContentView(R.layout.activity_barcode);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.article_lists);
        mActivityComponent.navigator().goToLists();
    }

    @Override
    protected void onDestroy() {
        // This makes the object graph eligible for garbage collection
        mActivityComponent = null;
        super.onDestroy();
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



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.articles) {
            mActivityComponent.navigator().goToArticles();
        } else if (id == R.id.article_lists) {
            mActivityComponent.navigator().goToLists();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void createAndInjectActivityComponent() {
        mActivityComponent = BarcodeApp.getComponent().activityComponent(new ActivityModule(this));
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    public interface PictureListener {
        void onPictureTaken();
        void onError();
    }

    public void takePicture(PictureListener pictureListener, Uri photoURI) {
        mPictureListener = pictureListener;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } else {
            mPictureListener.onError();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            mPictureListener.onPictureTaken();
        } else {
            mPictureListener.onError();
        }
    }
}
