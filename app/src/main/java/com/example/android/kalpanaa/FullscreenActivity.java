package com.example.android.kalpanaa;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import java.util.Locale;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;
    ViewPager viewPager,viewPager2;
    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };

    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);



viewPager=(ViewPager) findViewById(R.id.view_pager);

ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);
viewPager.setAdapter(viewPagerAdapter);

        viewPager2=(ViewPager) findViewById(R.id.view_pager2);

        PricingAdapter viewPagerAdapter2=new PricingAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter2);

        // Set up the user interaction to manually show or hide the system UI.


        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.

    }

    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */


    public void changeLanguage(View v)
    {
        Intent i=new Intent(FullscreenActivity.this,Language.class);
        Bundle b = new Bundle();
        b.putString("Activity", "Full");
        i.putExtras(b);
    startActivity(i);}

    private void showChangeDialogBox() {
        final String[] listItems={"English","Hindi","Bengali","Marathi","Gujrati","Nepali","Tamil","Telegu"};
        AlertDialog.Builder mBuilder=new AlertDialog.Builder(FullscreenActivity.this);
        mBuilder.setTitle("Choose Language");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i==0)
                {
                    setLocale("en");
                    recreate();
                }
                else if(i==1)
                {
                    setLocale("hi");
                    recreate();
                }
                else if(i==2)
                {
                    setLocale("bn");
                    recreate();
                }
                else if(i==3)
                {
                    setLocale("mr");
                    recreate();
                }
                else if(i==4)
                {
                    setLocale("gu");
                    recreate();
                }
                else if(i==5)
                {
                    setLocale("ne");
                    recreate();
                }
                else if(i==6)
                {
                    setLocale("ta");
                    recreate();
                }
                else if(i==7)
                {
                    setLocale("te");
                    recreate();
                }


                dialog.dismiss();
            }
        });

        AlertDialog mDialog=mBuilder.create();
        mDialog.show();
    }

    private void setLocale(String language) {
        Locale locale=new Locale(language);
        Locale.setDefault(locale);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",language);
        editor.apply();
    }

    public void loadLocale()
    {SharedPreferences preferences=getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String lang=preferences.getString("My_Lang","");
        setLocale(lang);}
}
