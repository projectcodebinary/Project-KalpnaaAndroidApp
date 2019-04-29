package com.example.android.kalpanaa;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static com.example.android.kalpanaa.R.drawable.back2;

public class Language extends AppCompatActivity {
TextView textView1,textView2,textView3,textView4;
    ViewPager viewPagerLanguage;
    String select="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        Bundle b = getIntent().getExtras();
//        String str = b.getString("Activity", "");
//        if (str.equals("Splash")) {
//            loadLocale();
//        }
        setContentView(R.layout.language_dialog);

        showDialog();
//        showChangeDialogBox();

    }

    private void showChangeDialogBox() {
        final String[] listItems = {"English", "Hindi", "Bengali", "Marathi", "Gujrati", "Nepali", "Tamil", "Telegu"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Language.this);
        mBuilder.setTitle("Choose Language");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (i == 0) {
                    setLocale("en");
                    recreate();
                    inte();
                } else if (i == 1) {
                    setLocale("hi");
                    recreate();
                    inte();
                } else if (i == 2) {
                    setLocale("bn");
                    recreate();
                    inte();
                } else if (i == 3) {
                    setLocale("mr");
                    recreate();
                    inte();
                } else if (i == 4) {
                    setLocale("gu");
                    recreate();
                    inte();
                } else if (i == 5) {
                    setLocale("ne");
                    recreate();
                    inte();

                } else if (i == 6) {
                    setLocale("ta");
                    recreate();
                    inte();

                } else if (i == 7) {
                    setLocale("te");
                    recreate();
                    inte();
                }


                dialog.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();

    }

    public void inte() {
        Intent intent = new Intent(getApplicationContext(), FullscreenActivity.class);
        startActivity(intent);
    }

    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", language);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences preferences = getSharedPreferences("Settngs", Activity.MODE_PRIVATE);
        String lang = preferences.getString("My_Lang", "");
        if (preferences.getString("My_Lang", "").equals("")) {

            showChangeDialogBox();
        } else {
            setLocale(lang);
        }
    }

    public void showDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Language.this);


        View view = getLayoutInflater().inflate(R.layout.language_dialog, null);
        viewPagerLanguage = (ViewPager) view.findViewById(R.id.viewpagerlanguage);

        final ViewPagerLanguage viewPagerAdapter = new ViewPagerLanguage(this);
        viewPagerLanguage.setAdapter(viewPagerAdapter);




        builder.setView(view)
                .setTitle("SELECT LANGUAGE")
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        select=viewPagerAdapter.retSelect();
                        selectLoacale();
                        if(!select.equals(""))
                        inte();
                        else
                            Toast.makeText(getApplicationContext(),"Select a Language!!",Toast.LENGTH_SHORT).show();
                    }
                });
        final android.app.AlertDialog dialog = builder.create();
        dialog.show();
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
