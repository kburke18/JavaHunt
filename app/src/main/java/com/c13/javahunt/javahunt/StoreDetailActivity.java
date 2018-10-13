package com.c13.javahunt.javahunt;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreDetailActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private String[] stores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        Resources res = getResources();
        stores = res.getStringArray(R.array.arr);

        // Navigation/Hamburger button
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent in = getIntent();
        int index = in.getIntExtra("com.c13.javahunt.javahunt.INDEX", -1);

        if (index > -1) {
            String name = getStore(index);
            TextView storeInfo = findViewById(R.id.infoTextView);
            TextView storeName = findViewById(R.id.storeNameTextView);

            storeInfo.setText(name);
            storeName.setText(name);
        }

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(startIntent);
            }
        });
    }

    // Navigation selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // method for populating UI elements based on store index
    private String getStore(int index) {
        return stores[index];
    }
}
