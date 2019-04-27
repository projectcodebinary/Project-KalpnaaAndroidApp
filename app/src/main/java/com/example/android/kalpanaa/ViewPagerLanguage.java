package com.example.android.kalpanaa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;
import static android.support.v4.content.ContextCompat.startActivity;

public class ViewPagerLanguage extends PagerAdapter {
Entrance e =new Entrance();
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] texts1={R.string.English,R.string.Tamil};
    private Integer[] texts2={R.string.Hindi,R.string.Bengali};
    private Integer[] texts3={R.string.Telegu,R.string.Marathi};
    private Integer[] texts4={R.string.Nepali,R.string.Gujrati};
    TextView textView4,textView1,textView2,textView3,textView5,textView6,textView7,textView8;
    String select="";

    public ViewPagerLanguage(Context context) {

        this.context=context;
    }

    @Override
    public int getCount() {
        return texts1.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.activity_language,null);
        Log.i("Position ",position+"");
        if(position==0) {
            textView1 = (TextView) view.findViewById(R.id.language1);
            textView1.setText(texts1[position]);

            textView2 = (TextView) view.findViewById(R.id.language2);
            textView2.setText(texts2[position]);


            textView3 = (TextView) view.findViewById(R.id.language3);
            textView3.setText(texts3[position]);


            textView4 = (TextView) view.findViewById(R.id.language4);
            textView4.setText(texts4[position]);

            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    select=textView1.getText().toString();
                    Log.i("Language ",select+"");
                    setLocale("en");
                    inte();

                }
            });

            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    select=textView2.getText().toString();
                    setLocale("hi");

                    inte();
                    Log.i("Language ",select+"");

                }
            });

            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    select=textView3.getText().toString();
                    setLocale("te");

                    inte();
                    Log.i("Language ",select+"");

                }
            });

            textView4.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    select=textView4.getText().toString();
                    setLocale("ne");

                    inte();
                    Log.i("Language ",select+"");

                }
            });
        }
        else
        {
            textView5 = (TextView) view.findViewById(R.id.language1);
            textView5.setText(texts1[position]);

            textView6 = (TextView) view.findViewById(R.id.language2);
            textView6.setText(texts2[position]);


            textView7 = (TextView) view.findViewById(R.id.language3);
            textView7.setText(texts3[position]);


            textView8 = (TextView) view.findViewById(R.id.language4);
            textView8.setText(texts4[position]);

            textView5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    select=textView5.getText().toString();
                    Log.i("Language ",select+"");
                    setLocale("ta");

                    inte();

                }
            });
            textView6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    select=textView6.getText().toString();
                    Log.i("Language ",select+"");
                    setLocale("bn");

                    inte();
                }
            });

            textView7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    select=textView7.getText().toString();
                    Log.i("Language ",select+"");
                    setLocale("mr");

                    inte();
                }
            });

            textView8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    select=textView8.getText().toString();
                    Log.i("Language ",select+"");
                    setLocale("gu");
                    inte();
                }
            });

        }




        ViewPager vp=(ViewPager) container;
        vp.addView(view,0);
        return view;
    }



    public String retSelect()
    {return select;}

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp=(ViewPager) container;
        View view=(View) object;
        vp.removeView(view);
    }

    public void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;

        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = context.getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", language);
        editor.apply();
    }

    public void inte() {
        Intent intent = new Intent(context.getApplicationContext(), FullscreenActivity.class);
        context.startActivity(intent);
    }





}
