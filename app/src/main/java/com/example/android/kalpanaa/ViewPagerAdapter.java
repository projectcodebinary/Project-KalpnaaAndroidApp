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

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images={R.drawable.eg,R.drawable.gg,R.drawable.sc};
    private Integer[] textHeaders={R.string.EconomicGrowth,R.string.NarrowingGenderGap,R.string.SocialChange};
    private Integer[] texts={R.string.EconomicGrowthString,R.string.NarrowingGenderGapString,R.string.SocialChangeString};
    public ViewPagerAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        TextView textView=(TextView) view.findViewById(R.id.textView);
        textView.setText(texts[position]);
        TextView textViewHeader=(TextView) view.findViewById(R.id.textViewheader);
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
