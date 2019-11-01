package com.example.analis23;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class SplashActivity extends AppCompatActivity {

   private ImageView mLogo;
   private TextView mainTitle ;
   private void initializeWidget() {
       mLogo = findViewById(R.id.mLogo);
       mainTitle = findViewById(R.id.mainTitle);
   }
   private void showSplashAmination (){
       Animation animation = AnimationUtils.loadAnimation(this, R.anim.top_to_bottom);
       mLogo.startAnimation(animation);

       Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
       mainTitle.startAnimation(fadeIn);
   }

   private void goToDashboard(){
       Thread t = new Thread(){
           @Override
           public void run(){
               try {
                   sleep(2000);

                   Intent apasih = new Intent(SplashActivity.this,DashboardActivity.class);
                   startActivity(apasih);
                super.run();
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }

       };
       t.start();

   }

   @Override
   protected void attachBaseContext(Context newBase){
       super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.initializeWidget();
        this.showSplashAmination();
        this.goToDashboard();
    }


}