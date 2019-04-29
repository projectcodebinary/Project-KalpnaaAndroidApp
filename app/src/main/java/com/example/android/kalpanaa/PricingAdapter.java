package com.example.android.kalpanaa;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PricingAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] textHeaders={R.string.Basic,R.string.Standard,R.string.Premium};
    private Integer[] texts={R.string.BasicString,R.string.StandardString,R.string.PremiumString};
    public PricingAdapter(Context context) {

        this.context=context;
    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.pricing_layout,null);
        TextView textView=(TextView) view.findViewById(R.id.pricingView);
        textView.setText(texts[position]);
        TextView textViewHeader=(TextView) view.findViewById(R.id.pricingViewheader);
        textViewHeader.setText(textHeaders[position]);

        ViewPager vp=(ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp=(ViewPager) container;
        View view=(View) object;
        vp.removeView(view);
    }
}
