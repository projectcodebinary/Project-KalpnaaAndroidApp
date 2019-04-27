package com.example.android.kalpanaa;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Entrance extends AppCompatActivity {

    TextView textView1,textView2,textView3,textView4;
    ViewPager viewPagerLanguage;
    String select="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
    }

    public void selectLanguage(View view)
    {
        showDialog();
       }

    public void inte() {
        Intent intent = new Intent(getApplicationContext(), FullscreenActivity.class);
        startActivity(intent);
    }

    public void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", language);
        editor.apply();
    }



    public void showDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Entrance.this);


        View view = getLayoutInflater().inflate(R.layout.language_dialog, null);
        viewPagerLanguage = (ViewPager) view.findViewById(R.id.viewpagerlanguage);

        final ViewPagerLanguage viewPagerAdapter = new ViewPagerLanguage(this);

        viewPagerLanguage.setAdapter(viewPagerAdapter);



        builder.setView(view);
        final android.app.AlertDialog dialog = builder.create();


        dialog.show();
        dialog.getWindow().setLayout(1000, 1320);

    }

    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }

    public void selectLoacale()
    { switch (select+"")
    {
        case "ENGLISH": setLocale("en");
            recreate();
            break;
        case "HINDI":   setLocale("hi");
            recreate();
            break;
        case "MARATHI":   setLocale("mr");
            recreate();
            break;
        case "TELEGU":   setLocale("te");
            recreate();
            break;
        case "BENGALI":   setLocale("bn");
            recreate();
            break;
        case "TAMIL":   setLocale("ta");
            recreate();
            break;
        case "NEPALI":   setLocale("ne");
            recreate();
            break;
        case "GUJRATI":   setLocale("gu");
            recreate();
            break;
    }}

}
