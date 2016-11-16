package com.example.kongalong.day27_home_work.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by kongalong on 2016/11/10.
 */
public class RecommendPagerAdapter2 extends PagerAdapter {

    private List<View> mPagerData1;

    public RecommendPagerAdapter2(List<View> pagerData1) {
        this.mPagerData1 = pagerData1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(mPagerData1.get(position));
    }

    @Override
    public int getCount() {
        return mPagerData1!=null?mPagerData1.size():0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        container.addView(mPagerData1.get(position));

        return mPagerData1.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
