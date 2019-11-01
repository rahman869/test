package com.example.analis23;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class DashboardActivity extends AppCompatActivity {

   LinearLayout viewScientistsCard;
   LinearLayout addScientistsCard;
   LinearLayout closeCard;

private void initializeWidgets(){
    viewScientistsCard = findViewById(R.id.viewScientistsCard);
    addScientistsCard = findViewById(R.id.addScientistsCard);
    closeCard = findViewById(R.id.closeCard);

    viewScientistsCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent apasih = new Intent(DashboardActivity.this,Tampil.class);
            startActivity(apasih);
        }
    });


    addScientistsCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent apasih = new Intent(DashboardActivity.this,TampilData.class);
            startActivity(apasih);
        }
    });

    closeCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();

        }
    });

}

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed(){
    super.onBackPressed();
    this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.initializeWidgets();
    }

}